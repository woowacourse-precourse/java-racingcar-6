package racingcar.util;

import racingcar.domain.collection.CarName;

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
            final String name,
            final List<CarName> carNames
    ) {
        validateCarNameEmpty(name);
        validateCarNameDuplicate(name, carNames);
    }

    private static void validateCarNameEmpty(final String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNameDuplicate(
            final String name,
            final List<CarName> carNames
    ) {
        Set<CarName> carNameSet = new HashSet<>(carNames);
        if (carNameSet.contains(name)) {
            throw new IllegalArgumentException();
        }
    }
}
