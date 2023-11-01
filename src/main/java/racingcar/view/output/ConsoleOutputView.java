package racingcar.view.output;

import java.io.PrintStream;

public class ConsoleOutputView extends OutputView {
    private final PrintStream standardOut;

    public ConsoleOutputView() {
        standardOut = System.out;
    }


    @Override
    public void print(final String text) {
        standardOut.print(text);
    }

    @Override
    public void println(final String text) {
        standardOut.println(text);
    }

}
