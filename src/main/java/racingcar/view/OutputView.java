package racingcar.view;

import java.util.List;
import racingcar.domain.result.RacingGameStatistics;
import racingcar.domain.winner.Winners;

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

    public static void showWinners(Winners winners) {
        System.out.println();
        System.out.println(winners.getWinnersMessage());
    }
}
