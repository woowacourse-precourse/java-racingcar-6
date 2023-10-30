package view;

import util.ProgressMessage;

public class MessagePrinter {
    static ProgressMessage start = ProgressMessage.START;
    static ProgressMessage inputTimes = ProgressMessage.INPUT_TIMES;
    static ProgressMessage result = ProgressMessage.RESULT;
    static ProgressMessage winner = ProgressMessage.WINNER;

    public static void start() {
        System.out.println(start.getMessage());
    }

    public static void inputTimes() {
        System.out.println(inputTimes.getMessage());
    }

    public static void result() {
        System.out.println(result.getMessage());
    }

    public static void winner() {
        System.out.println(winner.getMessage());
    }
}
