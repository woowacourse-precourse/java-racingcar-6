package racingcar.model;

import static racingcar.util.Message.COUNT_MUST_INT;
import static racingcar.util.Message.COUNT_MUST_POSITIVE_INT;
import static racingcar.util.Message.NAME_LIMIT_LENGTH;
import static racingcar.util.Message.NAME_MUST_SIZE;
import static racingcar.util.Message.NAME_NO_DISTINCT;
import static racingcar.util.Message.NAME_NO_WHITESPACE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static void name(List<Cars> cars) {
        nameLimitLength(cars);
        nameNoDuplicate(cars);
        nameMustSize(cars);
        nameNoWhiteSpace(cars);
    }

    private static void nameLimitLength(List<Cars> cars) {
        for (Cars car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException(NAME_LIMIT_LENGTH);
            }
        }
    }

    private static void nameNoDuplicate(List<Cars> cars) {
        Set<String> set = new HashSet<>();

        for (Cars car : cars) {
            set.add(car.getName());
        }

        if (set.size() != cars.size()) {
            throw new IllegalArgumentException(NAME_NO_DISTINCT);
        }
    }

    private static void nameMustSize(List<Cars> cars) {
        if (cars.size() < 1) {
            throw new IllegalArgumentException(NAME_MUST_SIZE);
        }
    }

    private static void nameNoWhiteSpace(List<Cars> cars) {
        cars.stream()
                .filter(car -> car.getName().trim().isEmpty())
                .findFirst()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(NAME_NO_WHITESPACE);
                });
    }

    public static void isPositiveInt(String count) {
        int result;

        try {
            result = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COUNT_MUST_INT);
        }

        if (result <= 0) {
            throw new IllegalArgumentException(COUNT_MUST_POSITIVE_INT);
        }
    }
}
