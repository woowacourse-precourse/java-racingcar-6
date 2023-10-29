package racingcar.view;

import java.util.List;
import racingcar.domain.result.RacingCarResult;

public class OutputView {

    public static void inputCarsNames() {
        System.out.println(Messages.INPUT_CARS_MESSAGE);
    }

    public static void inputTrial() {
        System.out.println(Messages.INPUT_TRIAL_MESSAGE);
    }

    public static void showRacingResult(List<RacingCarResult> results) {
        System.out.println();
        System.out.println(Messages.RESULT_MESSAGE);
        for (RacingCarResult result : results) {
            System.out.println(result.getResultMessage());
        }
    }

    public static void showWinners(List<String> winners) {
        System.out.println(Messages.WINNER_MESSAGE + String.join(Messages.COMMA, winners));
    }
}
