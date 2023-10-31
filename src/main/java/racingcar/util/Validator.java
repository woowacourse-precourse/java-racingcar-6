package racingcar.util;

import java.util.List;

public class Validator {
    public static void validateNameLength(String[] names, int digit) {
        for(String name : names) {
            if(name.length() > digit || name.replaceAll(" ","").length() == 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateNameEndsWithComma(String str) {
        if(str.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumber(int input) {
        if(input <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateNameDuplicate(List<String> names) {
        if(names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }
}
