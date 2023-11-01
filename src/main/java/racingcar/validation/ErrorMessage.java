package racingcar.validation;

public enum ErrorMessage {
  INVALID_LENGTH("[ERROR] 자동차의 이름이 유효하지 않습니다. (5글자 이하여야 합니다)"),
  DUPLICATED_NAME("[ERROR] 동명의 자동차가 존재하면 안됩니다."),
  EMPTY_INPUT("[ERROR] 빈 값이 입력되었습니다."),
  CONTAIN_LETTER("[ERROR} 시행 횟수는 숫자로만 입력해야 합니다."),
  NOT_NATURAL_NUM("[ERROR] 시행 횟수는 자연수여야 합니다.");

  private final String message;

  ErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
