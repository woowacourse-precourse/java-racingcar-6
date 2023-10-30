package validation;

public class StringValidator {

  private StringValidator() {
  }

  public static String checkLengthOver(final String checkString, final int comparisonNumber) {
    if (checkString.length() > comparisonNumber) {
      throw new IllegalArgumentException("자동차 이름은 " + comparisonNumber + "자 이하로 해주세요.");
    }

    return checkString;
  }

  public static String checkIntegerFormat(final String checkString) {
    try {
      Integer.parseInt(checkString);
    } catch (Exception e) {
      throw new IllegalArgumentException("숫자를 입력해주세요");
    }

    return checkString;
  }
}
