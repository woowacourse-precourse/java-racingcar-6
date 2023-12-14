package racingcar.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    INVALID_LENGTH_ERROR("잘못된 길이의 문자열을 입력하였습니다. "),
    DUPLICATED_CAR_ERROR("자동차의 이름이 중복되었습니다."),
    INVALID_TRY_COUNT_ERROR("잘못된 시도 횟수의 입력입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
