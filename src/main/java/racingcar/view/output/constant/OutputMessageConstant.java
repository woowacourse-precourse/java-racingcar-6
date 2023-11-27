package racingcar.view.output.constant;

public enum OutputMessageConstant {
    INSERT_CAR_NAMES_DIRECTION("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INSERT_TRIAL_TIMES_DIRECTION("시도할 횟수는 몇회인가요?"),
    EXECUTION_START_SIGN("실행 결과"),
    FINAL_WINNER_ANNOUNCEMENT_SIGN("최종 우승자 : ");

    private final String message;

    OutputMessageConstant(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}