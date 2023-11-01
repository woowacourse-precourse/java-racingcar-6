package racingcar.view;

public enum ErrorMessages {
    INVALID_ROUND_COUNT("경기 횟수는 1 이상의 양수로만 작성되어야합니다."),
    NAME_LENGTH_LIMIT("이름은 5글자 이하여야 합니다."),
    INVALID_INPUT_FORMAT("입력값은 숫자, 영문, 쉼표로만 구성되어야합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
