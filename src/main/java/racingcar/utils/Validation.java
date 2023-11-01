package racingcar.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Validation {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final Pattern specialChar = Pattern.compile("\\W");
    private static final Pattern allCharExceptNumber = Pattern.compile("\\D");
    private static final int TRIAL_LENGTH_MIN = 1;

    public static void validateName(String name) {
        isValidNameLength(name);
        hasSpecialCharacter(name);
    }

    private static void isValidNameLength(String name) throws IllegalArgumentException {
        if (name.length() < NAME_LENGTH_MIN
                || name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private static void hasSpecialCharacter(String name) throws IllegalArgumentException {
        if (specialChar.matcher(name).find()) {
            throw new IllegalArgumentException();
        }
    }

    public static void isDistinctNames(String[] names) throws IllegalArgumentException {
        Set<String> distinctNames = new HashSet<>();
        boolean isDistinctName;
        for (String name : names) {
            isDistinctName = distinctNames.add(name);
            if (!isDistinctName) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateTrial(String trial) throws IllegalArgumentException {
        if (trial.length() < TRIAL_LENGTH_MIN
                || allCharExceptNumber.matcher(trial).find()) {
            throw new IllegalArgumentException();
        }
    }
}
