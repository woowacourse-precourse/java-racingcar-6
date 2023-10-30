package racingcar.domain.console;

import racingcar.domain.console.input.ConsoleReader;
import racingcar.domain.console.output.ConsoleWriter;

public class Console {
    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    public Console(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public String[] inputNames() {
        consoleWriter.inputNamesMessagePrint();
        return consoleReader.readNames();
    }

    public int inputAttemptCount() {
        consoleWriter.inputCountMessagePrint();
        return consoleReader.readAttemptCount();
    }

}
