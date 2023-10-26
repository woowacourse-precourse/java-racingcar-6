package racingcar;

public class Validation {

    public static boolean hasIllegalName(String[] names) {

        if (names.length == 0) {
            return true;
        }

        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                return true;
            }
        }

        return false;
    }
}
