package util.exception;

public enum ExceptionMessage {
    INPUT_CAR_NAMES_EMPTY("경주할 자동차 이름을 입력하세요."),
    INPUT_CAR_NAMES_NOT_COMMA("경주할 자동차 이름은 쉼표로 구분해서 작성하세요."),
    INPUT_CAR_NAME_LENGTH_EXCEED("자동차 이름은 5자이하로 작성해야합니다.");

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
