package racingcar.message;

public enum ErrorMessage {
    INVALID_CAR_NAMES("잘못된 자동차 이름입니다. 자동차 이름은 1자 이상 5자 이하의 문자입니다."),
    INVALID_MOVE_CNT("잘못됩 입력입니다. 시도할 회수는 숫자를 입력해주세요."),
    ;

    private String message;

    ErrorMessage(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
