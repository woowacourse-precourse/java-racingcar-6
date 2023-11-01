package racingcar.message;

public enum OutputMessage {
    WINNER("최종 우승자 : "),
    CAR_FORWARD_PLACE("-"),;
    private final String msg;

    OutputMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
