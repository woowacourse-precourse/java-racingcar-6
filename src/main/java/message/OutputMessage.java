package message;

public enum OutputMessage {
    RESULT_HEADER_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : ");

    String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message;
    }
}
