package racingcar.output;

import static java.lang.String.format;

public class OutputCarRace {
    private OutputCarRace() {
    }

    public static void print(final MessageType messageType) {
        printMessage(messageType.getValue());
    }

    public static void printf(final MessageType messageType, final Object... inputNames) {
        printMessage(format(messageType.getValue(), inputNames));
    }

    private static void printMessage(String message) {
        System.out.print(message);
    }
}
