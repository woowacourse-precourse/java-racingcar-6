package racingcar.constant;

public enum GameMessage {
    REQUEST_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    REQUEST_ROUNDS("시도할 회수는 몇회인가요?"),
    FINAL_WINNER("최종 우승자 : "),
    COLON(" : "),
    DASH("-");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
