package racingcar.exception;

public enum CarExceptionMessage {
    ERROR_NAME_LENGTH("[ERROR] 입력할 수 있는 이름의 글자수는 최대 5입니다."),
    ERROR_NAME_BLANK("[ERROR] 공백을 입력할 수 없습니다."),
    ERROR_INIT_POSITION("[ERROR] 자동차의 시작 위치는 0입니다.");

    private final String message;

    CarExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
