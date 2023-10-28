package racingcar.domain.validator.exception;

public enum TryNumberException {
    NO_VALUE_TRY_NUMBER("시도할 회수가 입력되지 않았습니다."),
    INVALID_INTEGER_VALUE("입력된 값은 숫자만 허용됩니다."),
    INVALID_TOO_BIG_TRY_NUMBER("시도할 회수는 최대 10 번 이하로 가능합니다."),
    INVALID_TOO_SMALL_TRY_NUMBER("시도할 회수는 최소 1 번 이상으로 가능합니다.");

    private final String message;

    TryNumberException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}