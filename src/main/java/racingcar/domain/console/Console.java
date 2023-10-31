package racingcar.domain.console;

import racingcar.domain.console.input.ConsoleReader;
import racingcar.domain.console.output.ConsoleWriter;

public class Console {
    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    private Console(final ConsoleReader consoleReader, final ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public static Console of(final ConsoleReader consoleReader, final ConsoleWriter consoleWriter) {
        return new Console(consoleReader, consoleWriter);
    }

    public String[] inputNames() {
        consoleWriter.inputNamesMessagePrint();
        return consoleReader.readNames();
    }

    public int inputAttemptCount() {
        consoleWriter.inputCountMessagePrint();
        return consoleReader.readAttemptCount();
    }

    public void oneLapResultPrint(final String lapResult) {
        consoleWriter.println(lapResult);
    }

}
