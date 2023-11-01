package racingcar.constants;

public enum Messages {
    CARS_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    FORWARD_TRY_COUNT_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    RACING_WINNERS_OUTPUT("최종 우승자 : %s"),
    EXECUTION_RESULT("\n실행결과");

    private final String value;

    Messages(String value) {

        this.value = value;
    }

    public String show() {
        return value;
    }

}
