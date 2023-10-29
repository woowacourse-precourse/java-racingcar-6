package racingcar.util.message;

public enum Message {
    CHOOSE_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    CHOOSE_TIME_TO_RACE("시도할 회수는 몇회인가요?"),
    PlAY_RESULT("실행 결과");
    private final String message;
    private Message(final String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return message;
    }
}
