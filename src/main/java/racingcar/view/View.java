package racingcar.view;

import static racingcar.global.constants.MessageType.CAR_NAMES_REQUEST_MESSAGE;
import static racingcar.global.constants.MessageType.TOTAL_COUNT_REQUEST_MESSAGE;
import static racingcar.global.constants.NumberType.MIN_RACE_COUNT;
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

    public static String requestCount() {
        printlnMessage(TOTAL_COUNT_REQUEST_MESSAGE);
        String userInput = readLine();
        Validator.validateNumberInput(userInput);
        Validator.validateRange(userInput);
        return userInput;
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
        private static void validateNonBlankInput(final String input) {
            if (input.isBlank()) {
                throw RaceException.of(ErrorMessage.BLANK_INPUT_ERROR);
            }
        }

        /* validate requestCarNames() */
        private static void validateInvalidDelimiter(final String names) {
            if (isEdgeDelimiter(names) || hasContinuousDelimiters(names)) {
                throw RaceException.of(ErrorMessage.INVALID_DELIMITER_ERROR);
            }
        }

        private static boolean isEdgeDelimiter(final String names) {
            return startWithDelimiter(names) || endsWithDelimiter(names);
        }

        private static boolean startWithDelimiter(final String names) {
            return names.startsWith(DELIMITER.getSymbol());
        }

        private static boolean endsWithDelimiter(final String names) {
            return names.endsWith(DELIMITER.getSymbol());
        }

        private static boolean hasContinuousDelimiters(final String names) {
            return names.contains(generateContinuousDelimiters());
        }

        private static String generateContinuousDelimiters() {
            return DELIMITER.getSymbol().repeat(2);
        }

        /* validate requestCount() */
        public static void validateNumberInput(final String userInput) {
            if (isNotNumber(userInput)) {
                throw RaceException.of(ErrorMessage.INVALID_COUNT_FORMAT);
            }
        }

        private static boolean isNotNumber(final String userInput) {
            return !userInput.matches("\\d+");
        }

        public static void validateRange(final String userInput) {
            if (isLessThanMinCount(userInput)) {
                throw RaceException.of(ErrorMessage.INVALID_COUNT_RANGE);
            }
        }

        private static boolean isLessThanMinCount(final String userInput) {
            return Integer.parseInt(userInput) < MIN_RACE_COUNT.getValue();
        }
    }
}
