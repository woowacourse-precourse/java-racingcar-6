package racingcar.view;

import racingcar.enums.OutputMessage;

public class OutputView {
    public static void printStartMessageOfResult() {
        System.out.println(OutputMessage.START_OF_RESULT.getMessage());
    }

    public static void printResultMessageOfCarForward(String name, Integer forwardCount) {
        String outputFormat = OutputMessage.RESULT_OF_CAR_FORWARD_FORMAT.getMessage();
        String output = String.format(outputFormat, name, forwardCount);
        System.out.println(output);
    }

    public static void printWinnerOfGameMessage(String lists) {
        String outputFormat = OutputMessage.WINNER_OF_THIS_GAME_FORMAT.getMessage();
        String output = String.format(outputFormat, lists);
        System.out.println(output);
    }

    public static void printLineFeed() {
        System.out.println();
    }
}
