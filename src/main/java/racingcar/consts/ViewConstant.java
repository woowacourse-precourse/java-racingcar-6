package racingcar.consts;

public enum ViewConstant {

    RACING_CAR_PROMPT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    NUMBER_OF_ATTEMPT_PROMPT_MESSAGE("시도할 회수는 몇회인가요?"),
    RUN_RESULT_PRINT_MESSAGE("실행 결과"),
    DIVISION_MESSAGE(" : "),
    WINNER_PRINT_MESSAGE("최종 우승자" + DIVISION_MESSAGE.get()),
    DISTANCE_MESSAGE("-"),
    DELIMITER(",");

    private final String message;

    ViewConstant(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
