package racingcar.exception;

public enum Error {

    NOT_VALID_NAME("자동차 이름이 유효하지 않습니다.")
    ;
    private String msg;

    Error(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
