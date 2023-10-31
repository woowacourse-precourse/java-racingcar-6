package racingcar.View;

import java.util.Map;

public class SystemOutput {

    private static final String GAMEPLAY_RESULT = "실행 결과";
    private static final String RESULT_DELIMITER = " : ";
    private static final String SCORE_INDICATOR = "-";
    private static final String WINNER_ANNOUNCEMENT = "최종 우승자 : ";

    public static void printGameResult() {
        System.out.println(GAMEPLAY_RESULT);
    }

    public void printScore(Map<String,Integer> scoreBoard) {
        for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
            System.out.println(entry.getKey() + RESULT_DELIMITER + printIndicator(entry.getValue()));
        }
        System.out.println();
    }

    public String printIndicator(int score) {
        return SCORE_INDICATOR.repeat(Math.max(0, score));
    }

    public void printWinner(String winner) {
        System.out.print(WINNER_ANNOUNCEMENT);
        System.out.print(winner);
    }

}
