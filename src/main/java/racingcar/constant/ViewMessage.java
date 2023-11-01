package racingcar.constant;

public enum ViewMessage {
    INSERT_CARS_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INSERT_MOVING_COUNT("시도할 회수는 몇회인가요?"),
    GAME_RESULT("게임 결과");

    private final String text;

    ViewMessage(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
