package racingcar.view;

import java.util.ArrayList;

public class OutputView {
    public static final String DELIMITER_WINNER = ", ";

    public static void printPlayResult() {
        System.out.println("\n실행 결과");
    }

    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.println("최종 우승자 : " + String.join(DELIMITER_WINNER, winners));
    }
}
