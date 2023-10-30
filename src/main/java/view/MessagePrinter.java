package view;

import util.ProgressMessage;

public class MessagePrinter {
    static ProgressMessage start = ProgressMessage.START;
    static ProgressMessage inputTimes = ProgressMessage.INPUT_TIMES;
    static ProgressMessage result = ProgressMessage.RESULT;
    static ProgressMessage winner = ProgressMessage.WINNER;

    public static void startMessage() {
        System.out.println(start.getMessage());
    }

    public static void inputTimesMessage() {
        System.out.println(inputTimes.getMessage());
    }

    public static void resultMessage() {
        System.out.println(result.getMessage());
    }

    public static void winnerMessage() {
        System.out.println(winner.getMessage());
    }
}
