package racingcar.view;

public enum Description {
    INPUT_CARNAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_COUNT("시도할 횟수는 몇회인가요?"),
    WINNER("최종 우승자 : ");

    public final String str;

    Description(String str) {
        this.str = str;
    }
}