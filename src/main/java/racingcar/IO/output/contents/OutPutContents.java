package racingcar.IO.output.contents;

public class OutPutContents {

  private final RoundContents roundContents;
  private final FinalWinnerContents finalWinnerContents;

  private OutPutContents(RoundContents roundContents, FinalWinnerContents finalWinnerContents) {
    this.roundContents = roundContents;
    this.finalWinnerContents = finalWinnerContents;
  }

  public static OutPutContents of(RoundContents roundContents,
      FinalWinnerContents finalWinnerContents) {
    return new OutPutContents(roundContents, finalWinnerContents);
  }

  public RoundContents getRoundContents() {
    return roundContents;
  }

  public FinalWinnerContents getFinalWinnerContents() {
    return finalWinnerContents;
  }
}
