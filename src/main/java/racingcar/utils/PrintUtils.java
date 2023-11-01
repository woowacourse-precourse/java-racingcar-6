package racingcar.utils;

import racingcar.code.Message;

/**
 * PrintUtils
 * <pre>
 * Describe here
 * </pre>
 *
 * @version 1.0,
 */
public class PrintUtils {

    private PrintUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void print(Message message) {
        System.out.println(message.getDescription());
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
