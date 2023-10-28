package racingcar.view;

import racingcar.constant.Message;
import racingcar.constant.Separator;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printRaceResultHeader() {
        System.out.println(Message.RACE_RESULT_HEADER);
    }

    public static void printSingleCarResult(String carName, int forward) {
        System.out.println(carName + Separator.KEY_VALUE_SEPARATOR + "-".repeat(forward));
    }

    public static void lineBreak() {
        System.out.println();
    }

    public static void printRaceWinner(List<String> winners) {
        String listedWinners = String.join(Separator.OUTPUT_CAR_SEPARATOR, winners);
        System.out.println(Message.RACE_WINNER_ANNOUNCEMENT + Separator.KEY_VALUE_SEPARATOR + listedWinners);
    }
}
