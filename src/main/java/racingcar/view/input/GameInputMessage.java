package racingcar.view.input;

public enum GameInputMessage {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_RACE_COUNT("시도할 회수는 몇회인가요?"),
    ;

    String message;

    GameInputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
