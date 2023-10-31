package racingcar.message;

public enum Message {
    INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?"),
    ;

    private String message;

    Message(String msg) {
        this.message = msg;
    }

    @Override
    public String toString() {
        return message;
    }
}
