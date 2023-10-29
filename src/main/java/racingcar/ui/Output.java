package racingcar.ui;

public enum Output {

    GET_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    GET_GAME_COUNT("시도할 횟수는 몇회인가요?"),
    RESULT_COMMENT("실행 결과"),
    SEPARATOR(" : "),
    WINNER_COMMENT("최종 우승자 : ");

    private final String comment;

    Output(String comment) {
        this.comment = comment;
    }

    public void print() {
        System.out.println(comment);
    }

}
