package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_EXECUTION_RESULT = "\n실행 결과";
    private static final String OUTPUT_MOVE_RESULT = "%s : %s\n";
    private static final String OUTPUT_BLANK = "\n";
    private static final String OUTPUT_RACE_RESULT = "최종 우승자 : %s";

    public void outputExecutionResult() {
        System.out.println(OUTPUT_EXECUTION_RESULT);
    }

    public void outputMoveResult(String name, String dash) {
        System.out.printf(OUTPUT_MOVE_RESULT, name, dash);
    }

    public void outputBlank() {
        System.out.printf(OUTPUT_BLANK);
    }

    public void outputRaceResult(List<String> names) {
        System.out.printf(OUTPUT_RACE_RESULT, String.join(", ", names));
    }
}
