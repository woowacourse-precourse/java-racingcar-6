package racingcar.view.Message;

public enum GameViewMessage {
    WRITE_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    WRITE_RACE_LENGTH_MESSAGE("시도할 회수는 몇회인가요?"),
    OUTPUT_FIRST_LINE_MESSAGE("실행결과"),
    OUTPUT_WINNER_MESSAGE("최종 우승자"),
    COLONSTRING(":"),
    COMMA(","),
    SPACEBAR(" ");


    private final String message;

    GameViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
