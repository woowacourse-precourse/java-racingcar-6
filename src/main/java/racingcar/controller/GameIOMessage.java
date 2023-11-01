package racingcar.controller;

public enum GameIOMessage {
    INTRO_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ROUND_MESSAGE("시도할 회수는 몇회인가요?"),
    INPUT_DELIMITER(","),
    OUTPUT_DELIMITER(", "),
    WINNER_HEAD_MESSAGE("최종 우승자 : ");
    private final String message;

    GameIOMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

    public String getMessage() {
        return message;
    }
}
