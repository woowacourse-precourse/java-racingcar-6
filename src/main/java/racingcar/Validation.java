package racingcar;

import java.util.ArrayList;

public class Validation {
    private static int checkSize(String str) {
        return str.length();
    }

    public static void validateLengthOfName(ArrayList<String> input) {
        for (String s : input) {
            if (s.isEmpty() || checkSize(s) > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    public static void isNotNumber(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }


}
