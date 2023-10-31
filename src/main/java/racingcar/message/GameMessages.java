package racingcar.message;

public enum GameMessages {

    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MAX_ATTEMPTS("시도할 회수는 몇회인가요?"),
    GAME_RESULT("실행 결과"),
    WINNERS("최종 우승자 : "),
    RESULT_MARKER("-");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
