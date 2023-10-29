package racingcar.util;

import static racingcar.util.exception.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import racingcar.util.exception.RacingCarException;

public class Validator {
    public static void validateEmpty(String userInput) {
        if (isEmpty(userInput)) {
            throw RacingCarException.of(EMPTY_NUMBER);
        }
    }

    private static boolean isEmpty(String userInput) {
        return userInput.isEmpty();
    }

    public static void validateLength(List<String> splitUserInput) {
        if (!isValidLength(splitUserInput)) {
            throw RacingCarException.of(MORE_THAN_FIVE_CHARACTER);
        }
    }

    private static boolean isValidLength(List<String> splitUserInput) {
        Stream<String> strStream = splitUserInput.stream();
        return strStream.allMatch(s-> s.length() <= 5);
    }

    public static void validateDuplication(List<String> splitUserInput) {
        if (hasDuplication(splitUserInput)) {
            throw RacingCarException.of(DUPLICATED_NAME);
        }
    }

    private static boolean hasDuplication(List<String> splitUserInput) {
        Set<String> set = new HashSet<>(splitUserInput);
        return set.size() != splitUserInput.size();
    }


    public static void validatePositive(String userInput) {
        if (isLessThanOne(userInput)) {
            throw RacingCarException.of(LESS_THAN_ONE);
        }
    }

    private static boolean isLessThanOne(String userInput) {
        return Integer.parseInt(userInput) < 1;
    }

    public static void validateInteger(String userInput) {
        if (!isInteger(userInput)) {
            throw RacingCarException.of(NOT_INTEGER);
        }
    }

    private static boolean isInteger(String userInput) {
        return userInput.chars()
                .allMatch(Character::isDigit);
    }
}
