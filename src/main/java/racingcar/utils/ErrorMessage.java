package racingcar.utils;

public enum ErrorMessage {

    EMPTY_INPUT("입력 값은 공백일 수 없습니다."),
    LENGTH_OVER_5("플레이어의 이름은 6자 이상일 수 없습니다"),
    NOT_NUMBER("숫자가 아닌 값을 입력 값으로 받을 수 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
