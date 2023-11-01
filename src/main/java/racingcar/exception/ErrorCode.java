package racingcar.exception;

public enum ErrorCode {
    CAR_NAME_OVER_FIVE_LETTERS("자동차 이름은 5글자 이내이어야 합니다."),
    TRIAL_NUMBER_LESS_THAN_ZERO("자동차 시도횟수는 0을 초과해야합니다."),
    CAR_NAME_IS_BLANK("자동차 이름은 공백이어서는 안됩니다.");

    private final String message;

    ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
