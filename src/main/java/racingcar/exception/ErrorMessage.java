package racingcar.exception;

public enum ErrorMessage {
    ERROR_NAME_DUPLICATE("이름은 중복을 허용하지 않습니다."),
    ERROR_NAME_LENGTH("이름 길이는 5자 이하만 가능합니다."),
    ERROR_NAME_NO_SPACES("공백을 제외하고 입력해주세요."),
    ERROR_MINIMUM_NAMES("최소 2개 이상의 이름을 입력해주세요."),
    ERROR_NAME_IS_NOT_NULL("이름은 필수 입력값입니다."),
    ERROR_MINIMUM_TRY_COUNT("시도 횟수는 최소 1회 이상이어야 합니다."),
    ERROR_NUMBER_FORMAT_TRY_COUNT("시도 횟수는 숫자만 입력 가능합니다."),
    ERROR_TRY_COUNT_IS_NOT_NULL("시도 횟수는 필수 입력값입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(String... args) {
        return String.format(message, (Object[]) args);
    }

}
