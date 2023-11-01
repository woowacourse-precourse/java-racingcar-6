package racingcar.view;

public enum ErrorMessage {
    IS_NULL("요청한 질문에 맞는 값을 입력해주세요."),
    TOO_LONG("자동차의 이름은 5글자 이하로 작성해주세요."),
    SAME_NAME("자동차의 이름은 중복되지 않게 입력해주세요."),
    HAS_SPACE("공백은 사용 불가능합니다."),
    NOT_NUMBER("숫자를 입력해주세요.");


    private String message;
    ErrorMessage (String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
