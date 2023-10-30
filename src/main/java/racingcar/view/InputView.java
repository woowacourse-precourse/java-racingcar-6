package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import racingcar.view.printer.ConsolePrinter;
import racingcar.view.printer.Printer;
import racingcar.view.reader.ConsoleReader;
import racingcar.view.reader.Reader;

public class InputView {

    private static final String NAME_DELIMITER = ",";

    private static final String INPUT_NAMES_REQUEST_MESSAGE =
            String.format("경주할 자동차 이름을 입력하세요.(이름은 쉼표(%s) 기준으로 구분)%n", NAME_DELIMITER);

    private final Reader reader;
    private final Printer printer;

    InputView(Reader reader, Printer printer) {
        this.reader = Objects.requireNonNull(reader);
        this.printer = Objects.requireNonNull(printer);
    }

    public static InputView createConsoleView() {
        return new InputView(new ConsoleReader(), new ConsolePrinter());
    }

    public List<String> inputNames() {
        print(INPUT_NAMES_REQUEST_MESSAGE);
        return readNames();
    }

    private List<String> readNames() {
        String names = read();
        validateNames(names);
        return Arrays.asList(names.split(NAME_DELIMITER));
    }

    private void validateNames(String names) {
        if (names.isBlank()) {
            throw new IllegalArgumentException("적어도 하나의 문자를 입력해야 합니다");
        }
    }

    private void print(String message) {
        printer.print(message);
    }

    private String read() {
        return reader.read();
    }


}
