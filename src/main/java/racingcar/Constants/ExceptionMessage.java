package racingcar.Constants;

public enum ExceptionMessage {
    OUT_OF_LENGTH("1~5글자 사이의 이름을 입력 하십시오"),
    DUPLICATE_NAME("중복되지 않는 이름을 입력하세요"),
    NONE_INPUT("값을 입력 하세요"),
    NUMBER_ONLY("시도 횟수는 숫자만 입력 가능합니다"),
    NUMBER_OVERFLOW("int의 범위를 벗어났습니다.");

    private final String exceptionMassage;
    ExceptionMessage(String exceptionMessage){
        this.exceptionMassage = exceptionMessage;
    }

    public void throwexception(){
        throw new IllegalArgumentException(exceptionMassage);
    }
}
