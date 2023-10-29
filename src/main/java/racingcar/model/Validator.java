package racingcar.model;

import racingcar.Constants;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.isEmpty() || name.length() > Constants.NAME_SIZE || !name.matches(Constants.NAME_PATTERN)) {
                throw new IllegalArgumentException(Constants.NAME_SIZE_ERROR);
            }
        }
        validateDuplicateCarNames(carNames);
    }
    public static void validateAttempts(int numAttempts) {
        if (numAttempts <= 0) {
            throw new IllegalArgumentException(Constants.ROUND_SIZE_ERROR);
        }
    }
    private static void validateDuplicateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(Constants.NAME_DUPLICATE_ERROR);
        }
    }
}