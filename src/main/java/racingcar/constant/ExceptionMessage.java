package racingcar.constant;

public enum ExceptionMessage {
    INPUT_ERROR_DUPLICATED_CAR_NAME_MESSAGE("중복된 이름이 있습니다."),
    INPUT_ERROR_NUMBER_TYPE_MESSAGE("숫자만 입력해주세요."),
    INPUT_ERROR_CAR_COUNT_MESSAGE("자동차를 2대 이상 입력해주세요."),
    INPUT_ERROR_SPACE_MESSAGE("공백을 제외하고 입력해주세요."),
    INPUT_ERROR_CAR_TYPE_MESSAGE("문자(영문자)만 입력해주세요."),
    INPUT_ERROR_CAR_NAME_LENGTH_MESSAGE("자동차 이름은 1-5자까지 입력 가능합니다."),
    INPUT_ERROR_NUMBER_RANGE_MESSAGE("1이상의 숫자를 입력하세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
