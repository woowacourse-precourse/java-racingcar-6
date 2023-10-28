package racingcar.view;

import racingcar.enums.OutputMessage;

public class OutputView {
    public static void printStartMessageOfResult() {
        System.out.println(OutputMessage.START_OF_RESULT.getMessage());
    }

    public static void printNameAfterCarForward(String name) {
        String outputFormat = OutputMessage.FORMAT_OF_NAME_AFTER_CAR_FORWARD.getMessage();
        String output = String.format(outputFormat, name);
        System.out.print(output);
    }

    public static void printProgressAfterCarForward(Integer forwardCount) {
        String outputFormat = OutputMessage.FORMAT_OF_PROGRESS_AFTER_CAR_FORWARD.getMessage();
        String progressBar = OutputMessage.PROGRESS_BAR_OF_CAR_FORWARD.getMessage();

        String output = String.format(outputFormat, progressBar.repeat(forwardCount));
        System.out.print(output);
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
