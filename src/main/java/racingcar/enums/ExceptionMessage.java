package racingcar.enums;

public enum ExceptionMessage {
    OVER_FIVE_LETTERS("자동차 이름은 5자 이하로 입력해주세요."),
    CONTAINING_MORE_THAN_ONE_CAR("자동차 이름을 2개 이상 입력해주세요."),
    NOT_BLANK_NAME("이름은 빈 칸일 수 없습니다."),
    NOT_TOO_LONG_INPUT("너무 긴 값을 입력했습니다."),
    SHOULD_BE_NUMBER("숫자를 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
