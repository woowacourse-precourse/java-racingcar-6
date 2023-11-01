package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT = "\n실행 결과";

    public void printExecutionResult() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printRacingCarStatus(List<String> carStatus) {
        for (String status : carStatus) {
            System.out.println(status);
        }
        System.out.println();
    }

}