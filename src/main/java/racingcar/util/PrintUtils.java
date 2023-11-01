package racingcar.util;

import racingcar.enums.Message;

public class PrintUtils {
    private PrintUtils() {
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}