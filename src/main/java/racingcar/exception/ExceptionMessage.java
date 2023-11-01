package racingcar.exception;

public enum ExceptionMessage {
    OUT_OF_CAR_NAME_LENGTH("자동차의 이름은 6글자를 넘길 수 없습니다."),
    CAR_NAME_IS_BLANK("자동차의 이름이 공백이 될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차의 이름이 중복입니다."),
    EMPTY_CARS("자동차들이 존재하지 않습니다."),
    WRONG_CARS_NAME("자동차 이름을 잘못 입력하셨습니다."),
    ILLEGAL_TRY_COUNT("시도 횟수를 잘못 입력하셨습니다.");

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final String message;
    ExceptionMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return EXCEPTION_HEADER + message;
    }
}