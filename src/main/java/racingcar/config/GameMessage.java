package racingcar.config;

public enum GameMessage {
    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ROUND_COUNT("시도할 횟수는 몇회인가요?"),
    RACE_PROGRESS_PREFIX("실행결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
