package racingcar;

import java.util.List;

public class Validation {
    public static boolean validNames(String names) {
        return names.matches("^[a-zA-Z,]+$");
    }
    public static boolean validLength(List<String> nameList) {
        for(String name : nameList) {
            if(name.length() > 5 || name.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean validNumber(String number) {
        if(number.equals("0"))
            return false;
        return number.matches("^[0-9]+$");
    }
}
