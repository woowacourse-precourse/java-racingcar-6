package racingcar.view;

public enum GameMessage {
    START_GUIDE ("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    LOOP_COUNT_QUESTION ("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private String message;

    GameMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
