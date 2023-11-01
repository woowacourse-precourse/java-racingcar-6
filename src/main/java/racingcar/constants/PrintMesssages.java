package racingcar.constants;

public enum PrintMesssages {
    PROMPT_RACING_CARS_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PROMPT_GAME_ROUNDS("시도할 회수는 몇회인가요?"),
    ROUNDS_RESULT_TOP_MESSAGE("실행 결과");

    private final String message;

    PrintMesssages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
