package racingcar.view;

import racingcar.Constants;

import java.util.ArrayList;

public class OutputView {

    public static void printResultMessage() {
        System.out.println(Constants.ROUND_RESULT);
    }
    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }
}
