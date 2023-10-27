package racingcar.view;

public class OutputView {
    private static final String OUTPUT_EXECUTION_RESULT = "\n실행 결과";
    private static final String OUTPUT_MOVE_RESULT = "%s : %s\n";
    private static final String OUTPUT_BLANK = "\n";

    public void outputExecutionResult() {
        System.out.println(OUTPUT_EXECUTION_RESULT);
    }

    public void outputMoveResult(String name, String dash) {
        System.out.printf(OUTPUT_MOVE_RESULT, name, dash);
    }
    public void outputBlank() {
        System.out.printf(OUTPUT_BLANK);
    }
}
