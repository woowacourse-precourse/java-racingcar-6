package racingcar.view;

import racingcar.constant.ConsoleMessage;
import racingcar.constant.Separator;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printRaceResultHeader() {
        System.out.println(ConsoleMessage.RACE_RESULT_HEADER.getMessage());
    }

    public static void printSingleCarResult(String carName, int position) {
        System.out.println(carName + Separator.KEY_VALUE_SEPARATOR.getSeparator() + "-".repeat(position));
    }

    public static void lineBreak() {
        System.out.println();
    }

    public static void printRaceWinner(List<String> winners) {
        assert !winners.isEmpty();

        String winnerMessage = ConsoleMessage.RACE_WINNER_ANNOUNCEMENT.getMessage() + Separator.KEY_VALUE_SEPARATOR.getSeparator();
        String listedWinners = String.join(Separator.OUTPUT_CAR_SEPARATOR.getSeparator(), winners);
        System.out.println(winnerMessage + listedWinners);
    }
}
