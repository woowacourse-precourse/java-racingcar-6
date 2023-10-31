package racingcar.view;

import static racingcar.common.Config.*;


public class OutputView {
    public static void gameStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void inputCountMessage() {
        System.out.println(INPUT_COUNT_MESSAGE);
    }

    public static void startRacingMessage() {
        System.out.println(START_RACING_MESSAGE);
    }

    public static void printWinner(String stringList) {
        System.out.println(stringList);
    }

    public static void eachResultMessage(String result) {
        System.out.println(result);
    }
}
