package racingcar.util;

public class Validator {
    public static void validateNameLength(String[] names, int digit) {
        for(String name : names) {
            if(name.length() > digit) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateType(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
