package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static racingcar.app.RacingGameConst.*;

public class RacingGameValidator {

    public static void validateCarNameInput(final List<String> carNames) {
        validateCarNameInputEmpty(carNames);
        validateCarNameIncludeEmpty(carNames);
        validateCarNameDuplicate(carNames);
        validateCarNameLength(carNames);
    }

    private static void validateCarNameInputEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NAMES_EMPTY_MESSAGE);
        }
    }

    private static void validateCarNameIncludeEmpty(List<String> names) {
        Optional<String> emptyName = names.stream()
                .filter(s -> s.equals(""))
                .findAny();

        if (emptyName.isPresent()) {
            throw new IllegalArgumentException(NAMES_INCLUDE_EMPTY_MESSAGE);
        }
    }

    private static void validateCarNameLength(List<String> names) {
        Optional<String> overLengthName = names.stream()
                .filter(s -> s.length() > MAXIMUM_CAR_NAME_LENGTH)
                .findAny();

        if (overLengthName.isPresent()) {
            throw new IllegalArgumentException(NAMES_OVER_LENGTH_MESSAGE);
        }
    }

    private static void validateCarNameDuplicate(final List<String> carNames) {
        Set<String> carNameSet = new HashSet<>(carNames);
        if (carNameSet.size() != carNames.size()) {
            throw new IllegalArgumentException(NAMES_DUPLICATE_MESSAGE);
        }
    }

    public static void validateTrial(String input) {
        validateTrialIsNumber(input);
        validateTrialAtLeast(Integer.parseInt(input));
    }

    private static void validateTrialIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TRIAL_NOT_NUMBER_MESSAGE);
        }
    }

    private static void validateTrialAtLeast(int count) {
        if (count < MINIMUM_TRIAL_COUNT) {
            throw new IllegalArgumentException(TRIAL_SMALLER_THAN_MINIMUM);
        }
    }

}
