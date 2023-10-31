package racingcar.config;

import racingcar.domain.console.Console;
import racingcar.domain.console.input.ConsoleReader;
import racingcar.domain.console.input.InputParser;
import racingcar.domain.console.input.InputValidator;
import racingcar.domain.console.output.ConsoleWriter;

public class ConsoleFactory {

    private static Console console;

    private static ConsoleReader consoleReader;
    private static ConsoleWriter consoleWriter;

    private static InputValidator inputValidator;
    private static InputParser inputParser;

    private ConsoleFactory() {
    }

    protected static Console createSingletonConsole() {
        if (console == null) {
            console = Console.of(createSingletonConsoleReader(), createSingletonConsoleWriter());
        }
        return console;
    }

    private static ConsoleWriter createSingletonConsoleWriter() {
        if (consoleWriter == null) {
            consoleWriter = ConsoleWriter.newInstance();
        }
        return consoleWriter;
    }

    private static ConsoleReader createSingletonConsoleReader() {
        if (consoleReader == null) {
            consoleReader = ConsoleReader.of(createSingletonInputValidator(), createSingletonInputParser());
        }
        return consoleReader;
    }

    private static InputValidator createSingletonInputValidator() {
        if (inputValidator == null) {
            inputValidator = InputValidator.newInstance();
        }
        return inputValidator;
    }

    private static InputParser createSingletonInputParser() {
        if (inputParser == null) {
            inputParser = InputParser.newInstance();
        }
        return inputParser;
    }
    
}
