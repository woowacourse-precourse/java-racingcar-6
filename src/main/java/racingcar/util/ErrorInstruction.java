package racingcar.util;

public enum ErrorInstruction {
    CAR_NAME_LENGTH_ERROR_MESSAGE("[ERROR] 자동차 이름은 1자 이상 5자 이하로 입력해주세요."),
    TRIAL_COUNT_ERROR_MESSAGE("[ERROR] 시도 횟수는 숫자로 입력해주세요.");

    private final String message;

    ErrorInstruction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
