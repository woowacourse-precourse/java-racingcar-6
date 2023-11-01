package racingcar.constants;

public enum GameMessage {

    CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),
    EXECUTION_START_MESSAGE("실행 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
