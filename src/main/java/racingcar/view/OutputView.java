package racingcar.view;

import java.util.ArrayList;

import racingcar.Rule;

public class OutputView {

    public static void printPlayMessage() {
        System.out.println(Rule.ROUND_RESULT);
    }

    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(ArrayList<String> winners) {
        System.out.println(Rule.WINNER_RESULT + String.join(Rule.WINNER_DELIMETER, winners));
    }
}