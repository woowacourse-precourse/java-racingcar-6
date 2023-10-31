package racingcar.model;

import static racingcar.model.SystemValueConstants.nameMax;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name createName(String name) {
        valid(name);
        return new Name(name);
    }

    private static void valid(String userInputList) {
        validLength(userInputList);
        validBlankString(userInputList);
    }

    private static void validLength(String userInputList) {

        if (userInputList.length() > nameMax()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validBlankString(String userInputList) {
        if (userInputList.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
