package racingcar.component;

public class Printer {
    private Printer() {}

    private static Printer printer;

    public static Printer getPrinter() {
        if (printer == null) {
            printer = new Printer();
        }
        return printer;
    }

}
