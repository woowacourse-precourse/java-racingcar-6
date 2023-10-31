package racingcar.view;

public enum Message {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ATTEMPT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
