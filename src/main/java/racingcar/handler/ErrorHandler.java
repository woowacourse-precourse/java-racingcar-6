package racingcar.handler;

public enum ErrorHandler {

    INVALID_NUMBER("유효하지 않은 숫자입니다."),
    INVALID_INPUT("자동차 이름은 쉼표로 구분해야 합니다."),
    INVALID_ENGLISH_KOREAN("영어와 한글만 사용할 수 있습니다."),
    INVALID_RANGE("자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_NUMBER("중복된 이름은 들어갈 수 없습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        errorMessage = "[Error] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
