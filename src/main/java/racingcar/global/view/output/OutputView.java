package racingcar.global.view.output;

public class OutputView {

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static void printMessageLine(String message) {
        System.out.println(message);
    }

    public static void printMessage(GameMessage message) {
        System.out.print(message.getMessage());
    }

    public static void printMessageLine(GameMessage message) {
        System.out.println(message.getMessage());
    }
}
