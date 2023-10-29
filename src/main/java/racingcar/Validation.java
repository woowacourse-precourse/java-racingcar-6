package racingcar;

import java.util.List;

public class Validation {
    public static boolean validNames(String names) {
        return names.matches("^[a-zA-Z,]+$");
    }
    public static boolean validLength(List<String> nameList) {
        for(String name : nameList) {
            if(name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean validNumber(int number) {
        return false;
    }
}
