package racingcar.constant.errorMessage;

public enum ErrorMessages implements ErrorMessagesStatus {

    ROUND_IS_NOT_NUMERIC("숫자만 입력할 수 있습니다. 게임을 종료합니다."),
    CAR_NAME_IS_TOO_LONG("자동차 이름은 다섯 자 이하만 가능합니다. 게임을 종료합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
