package racingcar.message;

public enum InputErrorMessage {
  INPUT_CAR_NAME_NULL_ERROR("자동차 이름이 입력 되지 않았습니다."),
  INPUT_CAR_NAME_LENGTH_ERROR("자동차 이름이 5글자를 초과합니다"),
  INPUT_CAR_NAME_STRING_ERROR("자동차 이름은 문자열 이어야 합니다."),
  INPUT_CAR_NAME_DUPLICATED_ERROR("자동차 이름이 중복됩니다."),
  INVALID_CAR_GROUP("잘못된 CarGroup을 참조하고 있습니다."),
  INPUT_TRY_NUMBER_TYPE_ERROR("시도 횟수를 숫자로 입력해야 합니다.");

  public final String message;

  InputErrorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
