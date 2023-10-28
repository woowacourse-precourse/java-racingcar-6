package racingcar.message;

public enum ProcessMessage {
    INPUT_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
