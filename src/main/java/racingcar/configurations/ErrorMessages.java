package racingcar.configurations;

public enum ErrorMessages {
    NO_INPUT_MESSAGE("입력이 없습니다."),
    INVALID_NUMBER_OF_ROUNDS_MESSAGE("숫자를 입력해주세요"),
    INVALID_CAR_NAME_LENGTH_MESSAGE("자동차의 이름이 너무 깁니다.");

    String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
