package racingcar.util;

import static racingcar.constants.Messages.INVALID_INPUT_ERROR;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static final int MIN_RACE_COUNT = 1;
    private static final int MAX_RACE_COUNT = 10;

    public void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public void validateNameCount(String input) {
        String[] splitInput = input.split(",");
        if (splitInput.length < 2 || splitInput.length > 5) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public void validateNameLength(String input) {
        String[] splitInput = input.split(",");
        for (String carName : splitInput) {
            if (carName == null || carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }
        }
    }

    public void validateUniqueName(String input) {
        String[] splitInput = input.split(",");
        Set<String> set = new HashSet<>();
        for (String carName : splitInput) {
            set.add(carName);
        }
        if (set.size() != splitInput.length) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

    public void validateMoveCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count < MIN_RACE_COUNT || MAX_RACE_COUNT < count) {
                throw new IllegalArgumentException(INVALID_INPUT_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_ERROR);
        }
    }

}
