package racingcar.message;

public enum ExceptionMessage {
    INPUT_NO_CAR_NAME_MESSAGE("1개 이상의 자동차 이름을 입력해야 합니다."),
    INPUT_DUPLICATE_CAR_NAME_MESSAGE("모두 다른 자동차 이름을 입력해야 합니다."),
    INPUT_WRONG_CAR_NAME_LENGTH_MESSAGE("길이가 1이상 5이하인 자동차 이름을 입력해야 합니다."),
    INPUT_NO_COUNT_MESSAGE("시도 횟수를 입력해야 합니다."),
    INPUT_WRONG_RANGE_OF_COUNT_MESSAGE("시도 횟수는 1이상이어야 합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void throwException() {
        throw new IllegalArgumentException(exceptionMessage);
    }
}
