package racingcar.view;

import racingcar.constant.Constants;

import java.util.List;

public class OutputView {
    public static void printRoundResultMessage() {
        System.out.println(Constants.ROUND_RESULT);
    }

    public static void printRoundResult(List<String> roundResults) {
        roundResults.stream().forEach(result -> System.out.println(result));
    }

    public static void printWinner(String winner) {
        System.out.println(Constants.WINNER + Constants.KEY_VALUE_SEPARATOR + winner);
    }
}
