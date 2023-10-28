package racingcar.exception;

import java.util.List;

public class Exception {

    public static void checkPositive(int tryNum) {
        if (tryNum <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean checkNameValidation(List<String> carNameList, String s) {
        return s.contains(" ") || s.length() > 5 || carNameList.contains(s);
    }
}
