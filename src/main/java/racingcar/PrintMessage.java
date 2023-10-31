package racingcar;

public enum PrintMessage {
    INPUT_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }
}
