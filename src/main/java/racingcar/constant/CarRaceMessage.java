package racingcar.constant;

public enum CarRaceMessage {

    PROMPT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분"),
    PROMPT_COUNT("시도할 회수는 몇회인가요?");

    private final String message;

    CarRaceMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
