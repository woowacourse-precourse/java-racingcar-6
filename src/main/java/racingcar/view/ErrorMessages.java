package racingcar.view;

public enum ErrorMessages {
    ERROR_CAR_NAMES_BLANK("공백만 입력할 수 있습니다."),
    ERROR_CAR_NAMES_LENGTH("이름은 5자 이하만 가능합니다."),
    ERROR_CAR_NAMES_UNIQUE("중복이 존재합니다."),
    ERROR_TRY_COUNT_NUMERIC("숫자만 입력할 수 있습ㄴ디ㅏ."),
    ERROR_TRY_COUNT_RANGE("1 이하의 값은 입력할 수 없습니다.");

    private final String errorMessage;

    ErrorMessages(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
