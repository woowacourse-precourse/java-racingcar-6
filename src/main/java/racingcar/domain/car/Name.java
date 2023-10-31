package racingcar.domain.car;

import static racingcar.config.GameConfig.NAME_LENGTH_CONDITION;
import static racingcar.exception.ErrorMessage.VALIDATE_EMPTY_FOR_EACH_NAME;
import static racingcar.exception.ErrorMessage.VALIDATE_LENGTH_FOR_EACH_NAME;

public class Name {
    protected final String name;

    protected Name(String name) {
        validate(name);
        this.name = name;
    }

    public static void validate(String name) {
        validateEmpty(name);
        validateLength(name);
    }

    private static void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_EMPTY_FOR_EACH_NAME.getMessage());
        }
    }

    private static void validateLength(String name) {
        if (name.length() > NAME_LENGTH_CONDITION.getNumber()) {
            throw new IllegalArgumentException(String.format(VALIDATE_LENGTH_FOR_EACH_NAME.getMessage(), NAME_LENGTH_CONDITION.getNumber()));
        }
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }
}
