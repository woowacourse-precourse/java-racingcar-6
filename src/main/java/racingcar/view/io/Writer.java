package racingcar.view.io;

public class Writer {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageUsingFormat(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }
}
