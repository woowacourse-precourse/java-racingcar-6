package racingcar.io;

public class Output {

    public static void console(Object message) {
        System.out.print(message.toString());
    }

    public static void consoleLine() {
        System.out.println();
    }

    public static void consoleLine(Object message) {
        System.out.println(message.toString());
    }

}
