package racingcar.util;

import racingcar.domain.collection.CarNames;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingGameValidator {

    public static void validateGameCount(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCarName(
            final String input,
            final List<String> carNames,
            int count
    ) {
        validateCarNameEnough(input, count);

        for (int i = 0; i < count; i++) {
            String name = carNames.get(i);
            validateCarNameEmpty(name);
            validateCarNameDuplicate(name, carNames);
        }
    }

    public static void validateCarNameEnough(
            final String input,
            final int count
    ) {
        String[] names = input.split(",");
        if (names.length != count) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameEmpty(final String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameDuplicate(
            final String name,
            final List<String> carNames
    ) {
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.contains(name)) {
            throw new IllegalArgumentException();
        }
    }
}
