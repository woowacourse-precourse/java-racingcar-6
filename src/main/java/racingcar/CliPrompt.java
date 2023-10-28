package racingcar;

public enum CliPrompt {

    ENTER_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    NUMBER_OF_REPETITIONS("시도할 횟수는 몇회인가요?\n"),
    RACE_RESULT("실행 결과\n"),
    WINNERS_ARE("최종 우승자 : ");

    private String value;


    private CliPrompt(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
