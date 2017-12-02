package agh.iisg.lab;

import agh.iisg.lab.legal.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;

import static java.util.stream.Collectors.toList;

public class Parser {
  /**
   * Globally counts articles. Starts with -1 to offset preamble.
   */
  private AtomicInteger articleCounter = new AtomicInteger(-1);

  private Law law;

  public Parser(List<String> lines) {
    Arrays.asList(
      lines.parallelStream()
           .filter(l -> Constraints.filters.stream().allMatch(p -> p.test(l)))
           .map(line -> line + "\n")
           .reduce("", String::concat)
           .replaceAll(Constraints.dashedNewline.pattern(), "")
           .replaceAll(Constraints.skipNewlines.pattern(), " ")
           .replaceAll(Constraints.replaceSpaces.pattern(), "\n"))
          .stream()
          .map(Law::new)
          .forEach(law -> {
            this.law = law;

            this.parse(
              law,
              new ArrayList<>(Arrays.asList(
                new PartitionGenerator(Division::new, null),
                new PartitionGenerator(Chapter::new, null),
                new PartitionGenerator(Section::new, null),
                new PartitionGenerator(Article::new, articleCounter),
                new PartitionGenerator(Paragraph::new, null),
                new PartitionGenerator(Point::new, null),
                new PartitionGenerator(Letter::new, null),
                new PartitionGenerator(Indent::new, null)
              )));
          });
  }

  public Law getLaw() {
    return law;
  }

  /**
   * Recursively parse legal partitions using given list of generators.
   *
   * @param parent     parent object.
   * @param generators List<PartitionGenerators> providing constructor-lambdas, regex patterns and instance counters.
   */
  private void parse(Legal parent, ArrayList<PartitionGenerator> generators) {
    if (generators.size() == 0) return;

    PartitionGenerator generator = generators.remove(0);
    List<Legal> partitions =
      Arrays.stream(parent.getContent().split(generator.getSupplier().get().split().pattern()))
            .filter(line -> !line.isEmpty())
            .map(raw -> {
              Legal partition = generator.getSupplier().get();
              partition.setNumber(Integer.toString(generator.getCounter().incrementAndGet()));

              Matcher title = generator.getSupplier().get().matchTitle().matcher(raw);
              if (title.find()) {
                String foundTitle = title.group(0);
                raw = raw.replaceFirst(foundTitle, "");
                partition.setTitle(foundTitle.substring(0, foundTitle.length() - 1));
              }

              partition.setContent(raw);
              return partition;
            })
            .collect(toList());
    parent.setPartitions(partitions);

    partitions.stream()
              .forEach(partition -> this.parse(partition, new ArrayList<>(generators)));
  }
}