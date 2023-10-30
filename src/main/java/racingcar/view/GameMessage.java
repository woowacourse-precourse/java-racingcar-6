package racingcar.view;

public enum GameMessage {

    START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_RETRY_COUNT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    PERSONAL_RESULT("%s : %s"),
    WINNER("최종 우승자 : %s");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
