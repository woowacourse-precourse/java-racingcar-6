package racingcar.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private final static int NAME_MAX_LENGTH = 5;

    public static void validateRacersName(List<String> values) {
        if (!isDistinct(values) || !isMaxLength(values)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDistinct(List<String> values) {
        Set<String> uniqueValues = new HashSet<>(values);
        return uniqueValues.size() == values.size();
    }

    private static boolean isMaxLength(List<String> values) {
        return values.stream().allMatch(value -> value.length() <= NAME_MAX_LENGTH);
    }

    public static void validateMoveNumber(String values) {
        if (values == null || values.isEmpty()) {
                throw new IllegalArgumentException();
        }

        try {
            Integer.parseInt(values);
        } catch (IllegalArgumentException e) {

        }
    }
}
