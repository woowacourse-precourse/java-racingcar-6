package racingcar.view;

public enum Print {
    ASKING_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASKING_NUMBER_OF_TRIAL("시도할 회수는 몇회인가요?"),
    RACE_RESULT("실행 결과"),
    FINAL_WINNERS("최종 우승자 : ");

    private final String value;

    Print(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
