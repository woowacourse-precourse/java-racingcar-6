package racingcar.domain;

public class Validation {

    public static boolean isNameValid(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCntValid(String cnt) {
        if (cnt.matches("[0-9]+")) {
            if (cnt.equals("0")) {
                return false;
            }
            return true;
        }
        return false;
    }

}
