package racingcar.validation;

public enum ErrorMessage {
  INVALID_LENGTH("자동차의 이름이 6글자를 넘으면 안됩니다."),
  DUPLICATED_NAME("동명의 자동차가 존재하면 안됩니다."),
  CONTAIN_LETTER("숫자가 아닌 값이 입력되었습니다."),
  EMPTY_INPUT("입력 값이 없습니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
