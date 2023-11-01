package racingcar.view;

import java.util.List;

public class RacingGameView {
    public static String[] getCarNames() {
        return RacingGameInputView.getCarNames();
    }

    public static int getTotalAttempts() {
        return RacingGameInputView.getTotalAttempts();
    }

    public static void printRaceResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void printWinners(List<String> winners) {
        RacingGameOutputView.printWinners(winners);
    }
}
