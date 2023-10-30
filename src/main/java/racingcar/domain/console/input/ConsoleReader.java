package racingcar.domain.console.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleReader {
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final static String DELIMITER = ",";

    private ConsoleReader(InputValidator inputValidator, InputParser userNameParser) {
        this.inputValidator = inputValidator;
        this.inputParser = userNameParser;
    }

    public ConsoleReader of(InputValidator inputValidator, InputParser userNameParser) {
        return new ConsoleReader(inputValidator, userNameParser);
    }

    public String[] readNames() {
        String inputNames = readLine();
        String[] names = inputParser.parseUserNames(inputNames, DELIMITER);

        for (String name : names) {
            inputValidator.validateNameLength(name);
        }

        return names;
    }

    public int readAttemptCount() {
        String inputAttempCount = readLine();
        int count = inputParser.parseInt(inputAttempCount);
        inputValidator.validateAttemptSize(count);

        return count;
    }

}
