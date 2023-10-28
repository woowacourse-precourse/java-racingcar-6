package racingcar.exception;

import java.util.List;

public class Exception {

    public static int checkPositive(int tryNum) {
        if (tryNum <= 0) {
            throw new IllegalArgumentException();
        }
        return tryNum;
    }

    public static boolean checkNameValidation(List<String> carNameList, String s) {
        return s.contains(" ") || s.length() > 5 || carNameList.contains(s);
    }
}
