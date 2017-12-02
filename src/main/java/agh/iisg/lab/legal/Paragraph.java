package agh.iisg.lab.legal;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Paragraph
 * Corresponds to "Ustęp" written as "{index as number}.". Index is local to
 * the enclosing section and starts at 1.
 */
public class Paragraph extends LegalPartition {
  public static final Pattern split = Pattern.compile("\n\\d+\\. ");
  public static final Pattern matchTitle = Pattern.compile("^\\d+\\. ");

  private Optional<String> number;

  public Paragraph() {
  }

  @Override
  public Pattern split() {
    return split;
  }

  @Override
  public Pattern matchTitle() {
    return matchTitle;
  }

  public String getNumber() {
    return number.orElse("");
  }

  public void setNumber(String number) {
    this.number = Optional.ofNullable(number);
  }

  @Override
  public String getTitle() {
    return null;
  }

  @Override
  public void setTitle(String Title) {
  }
}