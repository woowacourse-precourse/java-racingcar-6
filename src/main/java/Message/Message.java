package Message;

public enum Message {
    START("자동차 경주게임을 시작합니다."),
    INPUT("경주에 참여할 자동차명을 입력해 주세요 : "),
    TRY("시도할 횟수를 입력해 주세요 : "),
    WINNER("최종 우승자 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
