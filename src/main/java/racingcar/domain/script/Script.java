package racingcar.domain.script;

public enum Script {
    REGISTER("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n"),
    LAPS("시도할 회수는 몇회인가요?\n"),
    RESULT("실행 결과\n"),
    PRIZE_CEREMONY("최종 우승자 : ");

    private final String script;

    Script(String script) {
        this.script = script;
    }

    public void print(){
        System.out.print(script);
    }
}
