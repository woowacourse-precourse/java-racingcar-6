package racingcar;

import java.util.List;

public class OutputView {

    public static final String SCORE_BAR = "-";
    public static final String DELIMITER_CAR_NAMES = ",";

    public static void printRaceResult(List<String> carNames, int[] scores) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            printScore(scores[i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        String output = winnerPrintFormat(winners);
        System.out.println(output);
    }

    public static String winnerPrintFormat(List<String> winners) {
        return "최종 우승자 : " + String.join(DELIMITER_CAR_NAMES + " ", winners);
    }

    public static void printScore(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print(SCORE_BAR);
        }
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }
}
