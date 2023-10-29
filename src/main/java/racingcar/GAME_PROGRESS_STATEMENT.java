package racingcar;

public enum GAME_PROGRESS_STATEMENT {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT("시도할 회수는 몇회인가요?"),
    GAME_RESULT("실행 결과"),
    WINNER("최종 우승자 : ");
    private final String value;

    GAME_PROGRESS_STATEMENT(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
