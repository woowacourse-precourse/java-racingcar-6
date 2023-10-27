package racingcar.constants;

public enum ErrorMessage {

    DIVISION_CAR_NAME_ERROR("이름은 쉼표(,) 기준으로 구분해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
