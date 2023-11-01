package racingcar.view;

import static racingcar.utils.Constants.GAME_START_MESSAGE;
import static racingcar.utils.Constants.INSERT_COUNT_MESSAGE;
import static racingcar.utils.Constants.RESULT_MESSAGE;
import static racingcar.utils.Constants.WINNER_MESSAGE;

import java.util.ArrayList;

public class OutputView {
    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInsertCount() {
        System.out.println(INSERT_COUNT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void printWinner(String winners) {
        System.out.println(WINNER_MESSAGE + winners);
    }

    public static void printRoundResult(ArrayList<String> roundResults) {
        roundResults.forEach(System.out::println);
        System.out.println();
    }

}
