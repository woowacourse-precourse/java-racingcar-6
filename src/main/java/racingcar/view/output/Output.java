package racingcar.view.output;

public class Output {

    public static final String DISTANT_MARK = "-";

    public static void printMessage(OutputMessage outputMessage) {
        System.out.println(outputMessage.message);
    }

    public static void printMessage(OutputMessage outputMessage, String messageValue) {
        System.out.printf((outputMessage.message) + "%n", messageValue);
    }

    public static void printResultMessage(OutputMessage outputMessage, String name, int distance) {
        System.out.printf(outputMessage.message + "%n", name, joinCarsDistances(distance));
    }

    public static void printNewLine() {
        System.out.println();
    }

    private static String joinCarsDistances(int distance) {
        return DISTANT_MARK.repeat(distance);
    }
}
