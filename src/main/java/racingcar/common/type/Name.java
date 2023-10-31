package racingcar.common.type;

import racingcar.common.validator.NameValidator;

public final class Name {
    private final String name;

    private Name(String name) {
        String trimmedName = name.trim();
        NameValidator.validate(trimmedName);
        this.name = trimmedName;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    public String getName() {
        return name;
    }
}
