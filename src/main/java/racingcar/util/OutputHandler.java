package racingcar.util;

import racingcar.constants.PrintMesssages;

public class OutputHandler {
    public static void showMessageWithOutNewLine(String message) {
        System.out.print(message);
    }

    public static void showMessageWithNewLine(String message) {
        System.out.println(message);
    }

    public static void showMessageWithNewLine(PrintMesssages message) {
        System.out.println(message.getMessage());
    }
}
