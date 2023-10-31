package racingcar.view.console.util;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.ErrorMessage;
import racingcar.exception.InvalidInputException;

public class InputUtil {
    private InputUtil() {
    }

    public static String readNonEmptyLineInput() {
        String input = Console.readLine();
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INPUT_IS_EMPTY);
        }
        return input;
    }

    public static int readInt() {
        try {
            String input = readNonEmptyLineInput();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static int readNaturalInt() {
        int input = readInt();
        if (input < 1) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_POSITIVE_NUMBER);
        }
        return input;
    }
}