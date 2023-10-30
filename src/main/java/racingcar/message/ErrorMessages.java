package racingcar.message;

public enum ErrorMessages {

    DUPLICATE_NAME("같은 이름은 허용되지 않습니다."),
    MAX_ATTEMPT_EXCEED("최대 횟수(2147483647)를 초과하였습니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
