package racingcar.view;

public class ErrorView {

  public static void isBlankError() {
    throw new IllegalArgumentException("공백이나 스페이스바가 있어요");
  }

  public static void isLengthError() {
    throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
  }

  public static void isDuplicatedError() {
    throw new IllegalArgumentException("동일한 이름이 있다.");
  }

  public static int isNumber() {
    throw new IllegalArgumentException("숫자가 아닙니다.");
  }

}
