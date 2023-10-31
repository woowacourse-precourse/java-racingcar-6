package racingcar.exception;

public enum RacingCarError {

    NOT_VALID_NAME("자동차 이름이 유효하지 않습니다."),
    NOT_VALID_INPUT("잘못된 입력값을 입력하셨습니다.")
    ;
    private String msg;

    RacingCarError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
