package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String RESULT_PRINT_START_MESSAGE = "실행 결과";
    private static final String WINNER_PRINT_START_MESSAGE = "최종 우승자 : ";

    public void printMessageStartResult() {
        System.out.println();
        System.out.println(RESULT_PRINT_START_MESSAGE);
    }

    public void printResultsMoving(final List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        System.out.print(WINNER_PRINT_START_MESSAGE);
        System.out.println(String.join(", ", winners));
    }
}
