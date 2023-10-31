package racingcar.global.exception;

public enum ErrorMessage {
    EMPTY_VALUE("빈 값을 입력할 수 없습니다."),
    INVALID_LENGTH("차 이름은 5자를 초과할 수 없습니다."),
    NOT_A_NUMBER("단일 숫자를 입력해야 합니다."),
    INVALID_INPUT("이름은 영소문자, 숫자, 한글로 이루어질 수 있으며 ,로 구분되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
