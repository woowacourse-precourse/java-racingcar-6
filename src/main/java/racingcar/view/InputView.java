package racingcar.view;

import static racingcar.global.constants.SymbolType.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import racingcar.global.exception.ErrorMessage;
import racingcar.global.exception.RaceException;

public final class InputView {

    public static String readInput() {
        String input = Console.readLine();
        validateBlankInput(input);
        return input;
    }

    public static String readCarNames() {
        String carNames = readInput();
        validateInvalidDelimiter(carNames);
        return carNames;
    }

    private static void validateBlankInput(String input) {
        if (input.isBlank()) {
            throw RaceException.of(ErrorMessage.BLANK_INPUT_ERROR);
        }
    }

    private static void validateInvalidDelimiter(String names) {
        if (isEdgeDelimiter(names) || hasContinuousDelimiters(names)) {
            throw RaceException.of(ErrorMessage.INVALID_DELIMITER_ERROR);
        }
    }

    private static boolean hasContinuousDelimiters(String names) {
        return names.contains(generateContinuousDelimiters());
    }

    private static String generateContinuousDelimiters() {
        return DELIMITER.getSymbol().repeat(2);
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
}
