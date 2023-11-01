package racingcar.view.output;

import java.util.Map;

public class Output {

    public static void printMessage(OutputMessage outputMessage) {
        System.out.println(outputMessage.message);
    }

    public static void printMessage(OutputMessage outputMessage, String messageValue) {
        System.out.printf((outputMessage.message) + "%n", messageValue);
    }

    public static void printStatusMessage(OutputMessage outputMessage, Map<String, String> statusMap) {
        statusMap.forEach((name, distance) ->
                System.out.printf(outputMessage.message + "%n", name, distance));
    }

    public static void printNewLine() {
        System.out.println();
    }

}
