package racingcar.message;

public enum GameMessage {
    CAR_NAME_INPUT_NOTICE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_CNT_INPUT_NOTICE("시도할 회수는 몇회인가요?"),

    PROGRESS_RESULT("실행 결과");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
