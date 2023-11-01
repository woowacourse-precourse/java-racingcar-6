package racingcar.view.output;

public class Output {
    public void printInputCarName() {
        System.out.println(OutputConstants.INPUT_CAR_NAME);
    }

    public void printInputTryNumber() {
        System.out.println(OutputConstants.INPUT_TRY_NUMBER);
    }

    public void printExecutionResult() {
        System.out.println(OutputConstants.EXECUTION_RESULT);
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println(result);
    }

    public void printWinnerResult(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }
}
