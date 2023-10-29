package racingcar.message;

public enum ErrorMessage {
    UNDER_5_LENGTH("이름은 5자 이하로 입력해주세요"),
    INPUT_NOT_NUMBER("시도 회수는 숫자로 입력해주세요"),
    INPUT_ZERO("시도 회수는 1회 이상으로 입력해주세요"),
    NAME_HAS_BLANK("이름에 공백이 있습니다"),
    INPUT_NAME_NULL("이름이 입력되지 않앗습니다");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
