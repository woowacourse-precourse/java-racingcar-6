package racingcar.constant;

public enum CycleExceptionMessage {
    EMPTY_INPUT("입력은 비어 있을 수 없습니다."),
    NOT_NATURAL_NUMBER("자연수가 아닙니다.");

    private final String message;

    CycleExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
