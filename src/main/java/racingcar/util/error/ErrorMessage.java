package racingcar.util.error;

public enum ErrorMessage {
    NO_NUMBER("[ERROR] 숫자만 입력해주세요"),
    LOW_NUMBER("횟수는 1이상이어야 합니다."),
    OVER_NAME_LENGTH("이름은 5자 이하만 가능합니다.");

    private final String errorMessage;
    private ErrorMessage(final String message) {
        this.errorMessage = message;
    }
    @Override
    public String toString() {
        return errorMessage;
    }
}
