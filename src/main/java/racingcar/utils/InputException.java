package racingcar.utils;

import racingcar.domain.PrintMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {

    public static void isContainComma(String input) {
        if (!input.contains(","))
            throw new IllegalArgumentException(PrintMessage.ONLY_SPLIT_COMMA);
    }

    public static void validateNameSize(String name) {
        if (name.isEmpty() || name.length() > 5)
            throw new IllegalArgumentException(PrintMessage.FIVE_OR_LESS);
    }

    public static void validateNameDuplication(List<String> carList) {
        Set<String> set = new HashSet<>(carList);
        if (carList.size() != set.size())
            throw new IllegalArgumentException(PrintMessage.NOT_DUPLICATE_NAME);
    }

    public static void isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9')
                throw new IllegalArgumentException(PrintMessage.ONLY_NUMBER);
        }
    }

    public static void isNaturalNumber(int num) {
        if (num < 1)
            throw new IllegalArgumentException(PrintMessage.ONLY_NATURAL_NUMBER);
    }
}
