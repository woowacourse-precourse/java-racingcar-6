package racingcar;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_REPEAT_NUMBER("시도할 회수는 몇회인가요?"),
    GAME_RESULT("실행 결과"),
    GAME_WINNER("최종 우승자 : ");

    private final String message;

    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
