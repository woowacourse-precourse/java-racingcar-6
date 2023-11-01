package racingcar.util;

public enum ExceptionMessage {

    INVALID_CAR_NAME_FORMAT("자동차 이름은 영문, 한글, 숫자, 빈칸, 쉼표(,)만 가능합니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_TURN_FORMAT("회수 값은 정수 숫자만 가능합니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
