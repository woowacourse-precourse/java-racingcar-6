package racingcar.view;

public class OutputView {
    private static final String OUTPUT_EXECUTION_RESULT = "실행 결과";
    private static final String OUTPUT_MOVE_RESULT = "%s : %s";

    public static void outputExecutionResult() {
        System.out.println(OUTPUT_EXECUTION_RESULT);
    }

    public static void outputMoveResult(String name, String dash) {
        System.out.printf(OUTPUT_MOVE_RESULT, name, dash);
    }
}
