package racingcar.view.constants;

public enum Notice {
    ASK_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ATTEMPT_NUMBER("시도할 회수는 몇회인가요?");

    private final String message;

    Notice(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
