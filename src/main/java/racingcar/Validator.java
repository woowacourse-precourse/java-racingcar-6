package racingcar;

public class Validator {

    public static void validateNames(String names) {
        String CarNames[] = names.split(",");

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
}
