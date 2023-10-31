package racingcar.util;

import java.util.List;

public class NameValidator {
    public static void validateNameLengthBelowFive(List<String> nameList) {
        for (String name : nameList) {
            validateNameLengthBelowFive(name);
        }
    }

    private static void validateNameLengthBelowFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
