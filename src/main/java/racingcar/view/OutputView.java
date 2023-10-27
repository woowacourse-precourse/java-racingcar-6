package racingcar.view;

public class OutputView {
    private static final String EXECUTION_RESULT_START_MESSAGE = "\n실행 결과";

    public void printResult() {
        System.out.println(EXECUTION_RESULT_START_MESSAGE);
    }
    public void printMoveResult(String result) {
        System.out.println(result);
    }

    public void printWinCars(String winCars) {
        System.out.println(winCars);
    }
}
