package racingcar.util;

public enum ExceptionMessages {

    LENGTH("자동차의 이름은 1~5 글자 이어야 합니다."),
    DUPLICATION("자동차 이름이 중복됩니다."),
    EMPTY("아무 입력이 없습니다."),
    NOT_NUMBER("0~9 사이의 숫자만 입력해야 합니다.");

    private final String exceptionMessage;

    ExceptionMessages(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
