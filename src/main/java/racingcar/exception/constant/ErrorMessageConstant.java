package racingcar.exception.constant;

public enum ErrorMessageConstant {
    INPUT_EMPTY_ERROR_MESSAGE("값을 입력해주세요. 게임을 종료합니다."),
    CAR_NAME_LENGTH_SHORT_MESSAGE("각 자동차 이름은 1글자 이상 입력해야합니다. 게임을 종료합니다."),
    CAR_NAME_LENGTH_LONG_MESSAGE("각 자동차 이름은 5글자 이하로 입력해야합니다. 게임을 종료합니다."),
    CAR_NAME_DUPLICATE_MESSAGE("중복된 자동차 이름이 존재합니다. 게임을 종료합니다."),
    TRY_INPUT_IS_NOT_NUMBER_MESSAGE("숫자만 입력이 가능합니다. 게임을 종료합니다.");

    private final String message;

    ErrorMessageConstant(String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
