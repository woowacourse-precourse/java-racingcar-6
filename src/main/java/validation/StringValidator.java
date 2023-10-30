package validation;

public class StringValidator {
  private StringValidator() {}

  public static String validateStringLengthOver(String checkString, int comparisonNumber) {
    if(checkString.length() > comparisonNumber) {
      throw new IllegalArgumentException("자동차 이름은 " + comparisonNumber + "자 이하로 해주세요.");
    }

    return checkString;
  }
}
