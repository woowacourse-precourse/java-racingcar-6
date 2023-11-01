package racingcar.output.contents;

public enum PunctuationMarks {
  NEW_LINE("\n"),
  EMPTY(""),
  SPACE(" "),
  COMMA(","),
  COLON(":"),
  EMPTY_COLON_EMPTY(" : "),
  MINUS("-");

  private final String punctuationMark;

  PunctuationMarks(String punctuationMark) {
    this.punctuationMark = punctuationMark;
  }

  public String mark() {
    return punctuationMark;
  }
}
