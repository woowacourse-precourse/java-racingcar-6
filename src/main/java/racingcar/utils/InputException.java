package racingcar.utils;

import racingcar.domain.PrintMessage;

public class InputException {

    public static void isContainComma(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException(PrintMessage.ONLY_SPLIT_COMMA);
    }

    public static void validateNameSize(String name) {
        if (name.isEmpty() || name.length() > 5)
            throw new IllegalArgumentException(PrintMessage.FIVE_OR_LESS);
    }
}
