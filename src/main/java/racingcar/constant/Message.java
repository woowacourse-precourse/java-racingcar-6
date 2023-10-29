package racingcar.constant;

public enum Message {
    ASK_TRY_COUNT("시도할 회수는 몇회인가요?");

    private String message;

    Message(String message) {
        this.message = message;
    }
}