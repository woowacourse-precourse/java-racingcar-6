package racingcar.message;

public enum RacingCarMessage {
    ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_GAME_COUNT("시도할 횟수는 몇 회인가요?");

    final String message;

    RacingCarMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
