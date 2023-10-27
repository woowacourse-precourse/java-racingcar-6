package racingcar.view;

import java.util.List;
import racingcar.common.Config;

public class OutputView {
    public static void gameStartMessage() {
        System.out.println(Config.START_MESSAGE);
    }

    public static void inputCountMessage() {
        System.out.println(Config.INPUT_COUNT_MESSAGE);
    }

    public static void startRacingMessage() {
        System.out.println(Config.START_RACING_MESSAGE);
    }

    public static void printWinner(String stringList) {
        System.out.println(Config.WINNER_MESSAGE + stringList);
    }

    public static void eachResultMessgae(String result) {
        System.out.println(result);
    }
}
