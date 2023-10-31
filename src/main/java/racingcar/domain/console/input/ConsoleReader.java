package racingcar.domain.console.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleReader {
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final static String DELIMITER = ",";

    private ConsoleReader(final InputValidator inputValidator, final InputParser userNameParser) {
        this.inputValidator = inputValidator;
        this.inputParser = userNameParser;
    }

    public static ConsoleReader of(final InputValidator inputValidator, final InputParser userNameParser) {
        return new ConsoleReader(inputValidator, userNameParser);
    }

    public String[] readNames() {
        final String inputNames = readLine();
        final String[] names = inputParser.parseUserNames(inputNames, DELIMITER);

        for (String name : names) {
            inputValidator.validateNameLength(name);
        }

        return names;
    }

    public int readAttemptCount() {
        final String inputAttemptCount = readLine();
        final int count = inputParser.parseInt(inputAttemptCount);
        inputValidator.validateAttemptSize(count);

        return count;
    }

}
