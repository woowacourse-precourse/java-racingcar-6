package racingcar.constant;

public enum ErrorMessage {
    CAR_NAME_SIZE_ERROR("[ERROR] 자동차 이름은 5글자를 초과할 수 없습니다."),
    CAR_NAME_NULL_MESSAGE("[ERROR] 자동차 이름은 공백이 될 수 없습니다."),
    TRIAL_NOT_DIGIT_ERROR("[ERROR] 시도 회수는 정수만 입력할 수 있습니다."),
    INVALID_TRIAL_NUMBER_ERROR("[ERROR] 시도 회수는 0 이하일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
