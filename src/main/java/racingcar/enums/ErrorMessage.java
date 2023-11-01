package racingcar.enums;

public enum ErrorMessage {
    INVALID_COUNT("%d 이상의 정수만 입력할 수 있습니다."),
    INPUT_IS_NULL("아무런 값을 입력하지 않으셨습니다."),
    INVALID_MIN_CARS("최소한 %d개 이상의 자동차 이름을 입력해 주세요."),
    INVALID_CAR_NAME("자동차 이름은 영문 알파벳으로 작성해 주세요."),
    INVALID_CAR_NAME_SIZE("자동차 이름은 %d자 이하로 작성해 주세요."),
    DUPLICATE_CAR_NAMES("중복된 자동차 이름이 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
