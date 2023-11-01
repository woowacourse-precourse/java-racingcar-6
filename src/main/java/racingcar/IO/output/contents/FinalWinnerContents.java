package racingcar.IO.output.contents;

public class FinalWinnerContents {
  private final String finalWinnerContents;

  private FinalWinnerContents(String finalWinnerContents) {
    this.finalWinnerContents = finalWinnerContents;
  }

  public static FinalWinnerContents of(String finalWinnerContents) {
    return new FinalWinnerContents(finalWinnerContents);
  }

  public String getFinalWinnerContents() {
    return finalWinnerContents;
  }
}
