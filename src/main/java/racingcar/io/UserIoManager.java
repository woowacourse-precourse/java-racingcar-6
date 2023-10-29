package racingcar.io;

import java.util.List;
import racingcar.io.input.ConsoleReader;
import racingcar.io.output.ConsoleWriter;

public class UserIoManager {

    private final ConsoleReader consoleReader;
    private final ConsoleWriter consoleWriter;

    public UserIoManager(ConsoleReader consoleReader, ConsoleWriter consoleWriter) {
        this.consoleReader = consoleReader;
        this.consoleWriter = consoleWriter;
    }

    public List<String> readCarNames() {
        consoleWriter.printCarNameInputGuide();
        return consoleReader.readCarNames();
    }

}
