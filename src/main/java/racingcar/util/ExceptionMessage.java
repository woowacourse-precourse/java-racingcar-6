package racingcar.util;


public enum ExceptionMessage {

    INVALID_NOT_NUMERIC("자연수만 입력 가능합니다."),
    INVALID_NUMBER_OF_CARS("자동차 경주는 두 대 이상부터 가능합니다."),
    INVALID_CAR_NAME_LENGTH("자동차의 이름은 1글자 이상 5글자 이하만 가능합니다."),
    INVALID_CAR_NAME_DUPLICATE("중복된 자동차 이름이 있습니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}