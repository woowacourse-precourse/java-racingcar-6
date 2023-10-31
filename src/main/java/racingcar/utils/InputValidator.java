package racingcar.utils;

import java.util.Arrays;

public class InputValidator {
    public static void validateCarNames(String carNames) {
        Arrays.stream(carNames.split(",", -1))
                .forEach(name -> {
                    validateCarNameIsNotBlank(name);
                    validateCarNameIsNotEmpty(name);
                    validateCarNameLength(name);
                });
    }

    private static void validateCarNameIsNotBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("the car name cannot be blank");
        }
    }

    private static void validateCarNameIsNotEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("the car name cannot be empty");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("the car name length cannot over 5 characters");
        }
    }

    public static void validateRaceRoundString(String raceRound) {
        try {
            Integer.parseInt(raceRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("the race round must be numeric value");
        }
    }

    public static void validateRaceRound(int raceRound) {
        if (raceRound < 1) {
            throw new IllegalArgumentException("the race round cannot be under 1");
        }
    }
}
