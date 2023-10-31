package racingcar.view;

import static racingcar.global.constants.MessageType.CAR_NAMES_REQUEST_MESSAGE;
import static racingcar.global.constants.SymbolType.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.constants.MessageType;
import racingcar.global.exception.ErrorMessage;
import racingcar.global.exception.RaceException;

public final class View {
    public static String requestCarNames() {
        printlnMessage(CAR_NAMES_REQUEST_MESSAGE);
        String userInput = readLine();
        Validator.validateInvalidDelimiter(userInput);
        return readLine();
    }

    private static void printlnMessage(final MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

    private static String readLine() {
        String userInput = Console.readLine();
        Validator.validateNonBlankInput(userInput);
        return userInput;
    }

    class Validator {
        private static void validateNonBlankInput(String input) {
            if (input.isBlank()) {
                throw RaceException.of(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }

        private static void validateInvalidDelimiter(String names) {
            if (isEdgeDelimiter(names) || hasContinuousDelimiters(names)) {
                throw RaceException.of(ErrorMessage.INVALID_DELIMITER_ERROR);
            }
        }

        private static boolean isEdgeDelimiter(String names) {
            return startWithDelimiter(names) || endsWithDelimiter(names);
        }

        private static boolean startWithDelimiter(String names) {
            return names.startsWith(DELIMITER.getSymbol());
        }

        private static boolean endsWithDelimiter(String names) {
            return names.endsWith(DELIMITER.getSymbol());
        }

        private static boolean hasContinuousDelimiters(String names) {
            return names.contains(generateContinuousDelimiters());
        }

        private static String generateContinuousDelimiters() {
            return DELIMITER.getSymbol().repeat(2);
        }
    }
}
