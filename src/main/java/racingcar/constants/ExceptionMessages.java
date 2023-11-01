package racingcar.constants;

public enum ExceptionMessages {
    NULL_INPUT("null은 입력할 수 없습니다."),
    EMPTY_INPUT("값을 입력해주세요."),
    WRONG_RANGE_CAR_NAME("자동차 이름은 1~5자로 입력해주세요."),
    WRONG_SEPERATOR_OR_RANGE("자동차 이름은 1~5자로, 구분자는 쉼표(,)를 사용해주세요."),
    DUPLICATED_CAR_NAMES("중복되는 이름은 입력할 수 없습니다."),
    NOT_NUMBER("숫자를 입력해주세요."),
    WRONG_RANGE_NUMBER("1 이상의 숫자를 입력해주세요.");

    private static final String ERROR_TAG = "[ERROR] ";
    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = ERROR_TAG + exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
