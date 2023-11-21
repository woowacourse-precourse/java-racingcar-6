package util.exception;

public enum ExceptionMessage {
    INPUT_CAR_NAMES_EMPTY("경주할 자동차 이름을 입력하세요."),
    INPUT_CAR_NAMES_NOT_COMMA("경주할 자동차 이름은 쉼표로 구분해서 작성하세요."),
    INPUT_CAR_NAME_LENGTH_EXCEED("자동차 이름은 5자이하로 작성해야합니다."),
    CAR_DUPLICATED_NAME("자동차 이름을 중복해서 입력하였습니다. 중복하지 않도록 작성하세요."),
    INPUT_ATTEMPTS_EMPTY("시도할 횟수를 입력하세요.");

    ExceptionMessage(String message){
        this.message = ERROR_TAG + message;
    }

    private static final String ERROR_TAG = "[ERROR] ";
    private final String message;

    public String getMessage(){
        return message;
    }

    public void throwException(){
        throw new IllegalArgumentException(message);
    }
}
