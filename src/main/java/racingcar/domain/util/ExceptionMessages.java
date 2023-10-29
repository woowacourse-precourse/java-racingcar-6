package racingcar.domain.util;

public enum ExceptionMessages {

    LENGTH("자동차의 이름은 1~5 글자 이어야 합니다."),
    DUPLICATION("자동차 이름이 중복됩니다.");

    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
