package racingcar.utility;

import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    public static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isInNameRange(String name) {
        return name.length() <= MAX_NAME_LENGTH;
    }

    public static boolean hasSameName(List<String> names) {
        return names.size() != Set.copyOf(names).size();
    }

}
