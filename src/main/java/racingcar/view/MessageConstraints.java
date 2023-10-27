package racingcar.view;

public enum MessageConstraints {

    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_MESSAGE("시도할 회수는 몇회인가요?");

    private final String value;

    public String getValue() {
        return value;
    }

    MessageConstraints(String value) {
        this.value = value;
    }
}
