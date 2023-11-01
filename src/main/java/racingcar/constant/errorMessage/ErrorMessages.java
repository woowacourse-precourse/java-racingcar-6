package racingcar.constant.errorMessage;

public enum ErrorMessages implements ErrorMessagesStatus {

    CAR_NAME_IS_TOO_LONG("자동차 이름은 다섯 자 이하만 가능합니다. 게임을 종료합니다."),
    CAR_NAME_IS_NULL_OR_BLANK("잘못된 입력입니다. 게임을 종료합니다."),
    CAR_NAME_IS_DUPLICATED("중복된 차량 이름은 입력될 수 없습니다. 게임을 종료합니다."),

    ROUND_IS_NOT_NUMERIC("잘못된 입력이거나 너무 큰 숫자를 입력하셨습니다. 게임을 종료합니다."),
    ROUND_IS_NOT_POSITIVE("양의 정수만 입력 가능합니다. 게임을 종료합니다.");

    private static final String MESSAGE_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessages(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
