package racingcar;

import racingcar.input.ValidateInput;

public final class Name {
    final String strName;
    static final int MAXIMUM_STRING_LENGTH = 5;

    private Name(String name) {
        this.strName = name;
    }

    public static Name createName(String name) {
        ValidateInput.validateStringCount(name, MAXIMUM_STRING_LENGTH);
        return new Name(name);
    }

    public String getName() {
        return strName;
    }
}
