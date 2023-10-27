package racingcar.util;

public enum ExceptionMessage {
    INPUT_NO_CAR_NAME_MESSAGE("경주할 자동차의 이름을 ,로 구분하여 입력해야 합니다."),
    INPUT_WRONG_CAR_LENGTH_MESSAGE("최소한 1개 이상의 자동차 이름을 입력해야 합니다."),
    INPUT_NO_COUNT_MESSAGE("시도 횟수를 입력해야 합니다."),
    INPUT_NOT_NUMBER_MESSAGE("숫자를 입력해야 합니다."),
    INPUT_WRONG_RANGE_OF_COUNT_MESSAGE("시도 횟수는 1이상이어야 합니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public void throwException(){
        throw new IllegalArgumentException(exceptionMessage);
    }
}
