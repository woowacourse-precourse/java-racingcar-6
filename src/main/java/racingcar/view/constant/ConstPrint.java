package racingcar.view.constant;

public enum ConstPrint {
    GAME_START("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ASK_ATTEMPT("시도할 회수는 몇회인가요?"),
    PRINT_RESULT("\n실행 결과"),
    PRINT_WINNER("최종 우승자");

    private final String constPrint;

    private ConstPrint(String constPrint){
        this.constPrint = constPrint;
    }

    public String getConstPrint(){
        return constPrint;
    }

}
