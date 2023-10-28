package racingcar.view;

public class OutputView {

    private final String EXECUTION_RESULT = "실행 결과";
    private final String WINNER = "최종 우승자 : ";

    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printCarRacingResult(String carList) {
        System.out.println(carList);
    }

    public void printWinner(String winner) {
        System.out.println(WINNER + winner);
    }
}
