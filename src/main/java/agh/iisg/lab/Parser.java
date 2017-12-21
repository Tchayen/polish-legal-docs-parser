package agh.iisg.lab;

import agh.iisg.lab.legal.LegalPartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Parser {
  /**
   * Globally counts articles. Starts with -1 to offset preamble.
   */
  private AtomicInteger articleCounter = new AtomicInteger(-1);

  private LegalPartition law;
  private List<LegalPartition> chapters;
  private List<LegalPartition> articles;

  public Parser(List<String> lines) {
    Stream.of(
      lines.parallelStream()
           .filter(l -> Constraints.filters.stream().allMatch(p -> p.test(l)))
           .map(line -> line + "\n")
           .reduce("", String::concat)
           .replaceAll(Constraints.dashedNewline.pattern(), "")
           .replaceAll(Constraints.skipNewlines.pattern(), " ")
           .replaceAll(Constraints.replaceSpaces.pattern(), "\n")
           .replaceAll(Constraints.joinTitles.pattern(), " ")
    )
          .map(LegalPartition::new)
          .forEach(law -> {
            this.law = law;

            if (law.getContent().startsWith("KONSTYTUCJA")) {
              law.setContent(law.getContent().split("\n", 5)[4]);
            } else {
              law.setContent(law.getContent().split("\n", 3)[2]);
            }

            ArrayList<PartitionGenerator> generators = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
              generators.add(new PartitionGenerator(i, i == 3 ? articleCounter : null));
            }

            this.parse(law, generators);

            chapters = this.law.getPartitions()
                               .stream()
                               .flatMap(division -> division.getPartitions()
                                                            .stream())
                               .collect(toList());

            articles = this.law
                    .getPartitions()
                    .stream()
                    .flatMap(division -> division.getPartitions().stream())
                    .flatMap(chapter -> chapter.getPartitions().stream())
                    .flatMap(section -> section.getPartitions().stream())
                    .collect(toList());
          });
  }

  public LegalPartition getLaw() {
    return law;
  }

  public List<LegalPartition> getChapters() {
    return chapters;
  }

  public List<LegalPartition> getArticles() {
    return articles;
  }

  /**
   * Recursively parse legal partitions using given list of generators.
   *
   * @param parent     parent object.
   * @param generators List<PartitionGenerators> providing constructor-lambdas, regex patterns and instance counters.
   */
  private void parse(LegalPartition parent, ArrayList<PartitionGenerator> generators) {
    if (generators.size() == 0) return;

    PartitionGenerator generator = generators.remove(0);
    List<LegalPartition> partitions =
      Arrays.stream(parent.getContent().split(Constraints.splitters.get(generator.getIndex()).pattern()))
            .filter(line -> !line.isEmpty())
            .map(raw -> {
              LegalPartition partition = new LegalPartition();
              partition.setNumber(Integer.toString(generator.getCounter().incrementAndGet()));

              Matcher title = Constraints.titleMatchers.get(generator.getIndex()).matcher(raw);
              if (title.find()) {
                String foundTitle = title.group(0);
                raw = raw.replaceFirst(foundTitle, "");
                partition.setTitle(foundTitle.substring(0, foundTitle.length() - 1));
                Matcher number = Constraints.numberExtractors.get(generator.getIndex()).matcher(title.group(0));
                if (number.find()) partition.setNumber(number.group(0));
              }
              partition.setContent(raw);
              return partition;
            })
            .collect(toList());
    parent.setPartitions(partitions);

    partitions.forEach(partition -> this.parse(partition, new ArrayList<>(generators)));
  }
}
