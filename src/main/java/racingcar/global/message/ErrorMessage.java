package racingcar.global.message;

public enum ErrorMessage {

    INPUT_IS_INVALID("입력한 값이 올바르지 않습니다 (NULL 또는 공백)."),
    INPUT_IS_NOT_NUMBER("입력한 값이 숫자가 아닙니다."),
    INPUT_OVER_MAX_LEN("입력한 자동차의 이름이 최대 길이를 넘었습니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    };
    
    public String getMessage() {
        return message;
    }
}
