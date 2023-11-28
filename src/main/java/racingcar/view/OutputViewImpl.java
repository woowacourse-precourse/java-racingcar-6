package racingcar.view;

public class OutputViewImpl implements OutputView {
    private static final String ENTER_RACE_RESULT = "실행 결과";
    @Override
    public void printExecution() {
        System.out.println(ENTER_RACE_RESULT);
    }

    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printFinalWinner(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
