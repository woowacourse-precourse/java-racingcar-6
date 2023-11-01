package racingcar.IO;

public enum PunctuationMarks {
  NEW_LINE("\n"),
  EMPTY(""),
  COMMA(","),
  COMMA_SPACE(", "),
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
