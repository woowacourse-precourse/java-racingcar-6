package racingcar.handler;

public enum ErrorHandler {

    INVALID_NUMBER("숫자가 아닌 값은 입력하실 수 없습니다."),
    INVALID_INPUT("자동차 이름은 쉼표로 구분해야 합니다."),
    INVALID_ENGLISH_KOREAN("영어와 한글만 사용할 수 있습니다."),
    INVALID_LENGTH("자동차 이름은 5자 이하만 가능합니다."),
    INVALID_RANGE("시도하는 회수는 1 이상의 값입니다."),
    MAX_VALUE_MISSING("최대값을 찾을 수 없습니다."),
    DUPLICATE_NUMBER("중복된 이름은 들어갈 수 없습니다.");

    private final String errorMessage;

    ErrorHandler(String message) {
        errorMessage = "[Error] " + message;
    }

    public RuntimeException getException() {
        return new IllegalArgumentException(errorMessage);
    }
}
