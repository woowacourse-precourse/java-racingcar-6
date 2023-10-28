package racingcar.enums;

public enum InputMessage {
    NAME_OF_THE_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_ATTEMPTS("시도할 횟수는 몇회인가요?");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
