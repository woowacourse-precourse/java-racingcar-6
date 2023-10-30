package racingcar;

public enum GameMessages {
    MESSAGE_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    MESSAGE_ASK_TRY("시도할 회수는 몇회인가요?\n"),
    MESSAGE_RACE_RESULT("실행 결과\n"),
    MESSAGE_ANNOUNCE_WINNER("최종 우승자 : ");

    private String msgType;

    GameMessages(String msgType) {
        this.msgType = msgType;
    }

    public String getMessage() {
        return msgType;
    }
}
