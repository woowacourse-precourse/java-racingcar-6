package racingcar.view;

import racingcar.Constants;

public class OutputView {
    public static void printGameResult() {
        System.out.print(Constants.OUTPUT_GAME_RESULT);
    }

    public static void printGameWinner(String winner) {
        System.out.printf(Constants.OUTPUT_GAME_WINNER, winner);
    }

    public static void printCarName(String carName) {
        System.out.printf(Constants.OUTPUT_CAR_NAME, carName);
    }

    public static void printHyphen() {
        System.out.print(Constants.OUTPUT_HYPHEN);
    }

    public static void printBlankLine() {
        System.out.print(Constants.OUTPUT_BLANK_LINE);
    }

    public static void printInputCarNames() {
        System.out.print(Constants.INPUT_CAR_NAMES);
    }

    public static void printInputNumber() {
        System.out.print(Constants.INPUT_NUMBER);
    }
}
