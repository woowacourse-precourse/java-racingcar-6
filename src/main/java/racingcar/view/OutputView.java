package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String EXECUTE_RESULT_HEADER = "실행 결과";
    private static final String COMMA = ", ";
    private static final String WINNER_IS = "최종 우승자 : ";

    public static void displayRoundResultHeader() {
        System.out.println(EXECUTE_RESULT_HEADER);
    }

    public static void displayRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public static void displayWinners(List<String> winnerNames) {
        System.out.println(WINNER_IS + String.join(COMMA, winnerNames));
    }
}
