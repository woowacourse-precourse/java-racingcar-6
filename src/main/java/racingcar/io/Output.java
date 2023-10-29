package racingcar.io;

import java.io.PrintStream;

public class Output {
    public static PrintStream out = null;

    public static PrintStream getInstance() {
        if (out != System.out) {
            out = System.out;
        }
        return out;
    }

    public static void println(Object message) {
        getInstance().println(message.toString());
    }

    public static void print(Object message) {
        getInstance().print(message.toString());
    }
}
