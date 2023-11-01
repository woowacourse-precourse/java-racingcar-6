package racingcar.util;

public enum Message {
    GAME_INIT("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT("시도할 회수는 몇회인가요?"),
    RESULT("실행 결과"),
    WINNER("최종 우승자");

    private final String constPrint;

    Message(String constPrint){
        this.constPrint = constPrint;
    }
    @Override
    public String toString() {
        return constPrint;
    }
}
