package racingcar.view;

import java.util.Objects;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.printer.Printer;

public class OutputView {

    private static final String LOCATION_RESULT_TITLE = String.format("%n실행 결과");

    private final Printer printer;

    OutputView(Printer printer) {
        this.printer = Objects.requireNonNull(printer);
    }

    public static OutputView createConsoleView() {
        return new OutputView(new ConsolePrinter());
    }

    public void printRacingResultTitle() {
        print(LOCATION_RESULT_TITLE);
    }

    private void print(String message) {
        printer.print(message);
    }
}
