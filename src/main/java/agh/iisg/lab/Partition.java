package agh.iisg.lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Partition {
  private String content;
  private List<Partition> partitions;
  private String number;
  private String title;
  private Map<String, Partition> resolveTitles = new HashMap<>();

  public Partition() {
  }

  public Partition(String rawContent) {
    this.content = rawContent;
  }

  public String getContent() {
    return content;
  }

  Partition getPartition(String title) {
    return resolveTitles.get(title);
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<Partition> getPartitions() {
    return partitions;
  }

  public void setPartitions(List<Partition> partitions) {
    this.partitions = partitions;
    this.partitions.forEach(partition -> resolveTitles.put(partition.getTitle(), partition));
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String toString() {
    return content;
  }
}
