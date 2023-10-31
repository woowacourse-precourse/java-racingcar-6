package racingcar.view;

import racingcar.util.Constants;

public class OutputView {
    public static void printRacingResult() {
        System.out.println(Constants.RACING_RESULT_MESSAGE);
    }

    public static void printProgress(String progress) {
        System.out.println(progress);
    }

    public static void printWinners(String winners) {
        System.out.printf(Constants.RACING_WINNER_MESSAGE, winners);
    }
}
