package racingcar.view;

import java.util.List;
import racingcar.constants.GameInfo;
import racingcar.constants.Messages;

public class OutputView {

    public static void printResultHeader() {
        System.out.println(Messages.OUTPUT_RESULT_HEADER.getMessage());
    }

    public static void printResultPerRound(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(Messages.OUTPUT_WINNER_PREFIX.getMessage() + String.join(GameInfo.WINNER_SEPARATOR, winners));
    }
}
