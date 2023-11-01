package racingcar.exception;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("이름은 5자 이하여야 합니다."),
    TRY_COUNT_INPUT_NON_NEGATIVE_ERROR("시도 횟수는 0 이상이어야 합니다."),
    INVALID_INPUT_ERROR("잘못된 입력입니다. 유효한 숫자를 입력해주세요."),
    CAR_NAME_INPUT_SIZE_ERROR("적어도 한 개 이상의 자동차 이름을 입력해주세요."),
    CAR_NAME_DUPLICATE_ERROR("중복된 차 이름이 있습니다. 각 차 이름은 고유해야 합니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
