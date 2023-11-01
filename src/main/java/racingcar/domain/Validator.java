package racingcar.domain;

public class Validator {
    public static boolean validate(String[] names) {
        boolean result = true;
        for (String name : names) {
            if (name.length() > 5) {
                result = false;
                IllegalArgumentException e = new IllegalArgumentException();
                throw e;
            }
        }
        return result;
    }
}
