package racingcar.model;

public enum PrintMessage {
    GET_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");

    String message;

    PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
