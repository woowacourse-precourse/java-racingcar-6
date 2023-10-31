package racingcar;

public enum PrintMessage {
    INPUT_RACING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_NUMBER_OF_ATTEMPTS("시도할 회수는 몇회인가요?");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }
}
