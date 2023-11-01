package racingcar.IO.output.contents;

import java.util.List;

public class RoundContents {

  private final List<String> contents;

  private RoundContents(List<String> contents) {
    this.contents = contents;
  }

  public static RoundContents of(List<String> contents) {
    return new RoundContents(contents);
  }

  public List<String> getContents() {
    return contents;
  }
}
