package racingcar.exception;

public enum ErrorCode {

    DUPLICATION_NAME("자동차 이름이 중복되었습니다."),
    NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    OVER_NAME_SIZE("이름이 5자리를 초과하였습니다.");

    private final String message;

    ErrorCode(String message){
        this.message = message;
    }

    public String getMessage() {
        return "[Error] " + message;
    }
}
