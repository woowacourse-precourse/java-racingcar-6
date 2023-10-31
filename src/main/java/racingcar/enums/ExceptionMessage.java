package racingcar.enums;

public enum ExceptionMessage {

    INPUT_NULL_EXCEPTION_MESSAGE("올바른 자동차 이름을 입력해주세요."),
    INPUT_LENGTH_EXCEPTION_MESSAGE("5자가 넘는 이름이 존재합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return message;
    }
}
