package racingcar.view;

import java.util.List;
import racingcar.domain.result.RacingGameStatistics;

public class OutputView {

    public static void inputCarsNames() {
        System.out.println(Messages.INPUT_CARS_MESSAGE);
    }

    public static void inputTrial() {
        System.out.println(Messages.INPUT_TRIAL_MESSAGE);
    }

    public static void showRacingResult(RacingGameStatistics results) {
        System.out.println();
        System.out.println(Messages.RESULT_MESSAGE);
        List<String> resultMessages = results.getStatisticsMessages();
        for (String resultMessage : resultMessages) {
            System.out.println(resultMessage);
        }
    }

    public static void showWinners(List<String> winners) {
        System.out.println();
        System.out.println(Messages.WINNER_MESSAGE + String.join(Messages.COMMA, winners));
    }
}
