package racingcar.exception;

public enum CarsExceptionMessage {

    ERROR_NAME_DUPLICATED("[ERROR] 중복된 이름으로 차를 생성할 수 없습니다.");

    private final String message;

    CarsExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
