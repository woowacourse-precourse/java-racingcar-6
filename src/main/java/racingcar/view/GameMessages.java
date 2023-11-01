package racingcar.view;

public enum GameMessages {
    START_GAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ROUNDS("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("실행결과"),
    FINAL_WINNER("최종 우승자 : %s"),
    CURRENT_POSITION("%s\n");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
