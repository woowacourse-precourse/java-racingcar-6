package racingcar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validateNames(String names) {
        String[] CarNames = names.split(",");

        if (names.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_NAME);
        }

        if (CarNames.length < 2) {
            throw new IllegalArgumentException(Messages.ERROR_SHORTAGE_PEOPLE);
        }

        for (String name : CarNames) {
            validateName(name);
        }
    }

    public static void validateName(String name) {
        if (name.length() > GameRuleNumbers.NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(Messages.ERROR_NAME_LIMIT_EXCESS);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_NAME);
        }
    }

    public static void validateNumber(String number) {
        Matcher matcher = GameRuleNumbers.NUMBER_FORMAT.matcher(number);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(Messages.ERROR_INCLUSION_STRING);
        }
        if (Integer.parseInt(number) < 1) {
            throw new IllegalArgumentException(Messages.ERROR_NUMBER_SMALL);
        }
    }
}
