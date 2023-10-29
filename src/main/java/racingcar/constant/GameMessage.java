package racingcar.constant;

public enum GameMessage {
    START_GAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REPEAT_NUMBER_REQUEST("시도할 횟수는 몇회인가요?");

    private final String message;

    private GameMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
