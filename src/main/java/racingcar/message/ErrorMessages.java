package racingcar.message;

public enum ErrorMessages {

    DUPLICATE_NAME("같은 이름은 허용되지 않습니다."),
    INVALID_NAME_LENGTH("이름의 길이는 5자를 넘을 수 없습니다."),
    INVALID_NAME("이름은 공백을 제외하고 최소 1글자 이상 입력하여야 합니다."),
    INVALID_ATTEMPT_COUNT("시도 횟수는 1 ~ 2147483647 사이의 정수값이어야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
