package racingcar.view;

public enum SystemMessage {
    ASK_CAR_LIST("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_NUM_OF_MATCHES("시도할 회수는 몇회인가요?"),
    TESTING("\n실행 결과");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
