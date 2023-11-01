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

    public void printRoundResult(String result) {
        System.out.println(result);
    }
}
