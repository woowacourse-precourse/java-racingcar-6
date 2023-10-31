package racingcar.util;

import racingcar.constants.PrintMesssages;

public class OutputHandler {
    public static void showMessage(String message) {
        System.out.println(message);
    }

    public static void showMessage(PrintMesssages message) {
        System.out.println(message.getMessage());
    }
}
