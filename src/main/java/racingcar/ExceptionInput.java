package racingcar;

import java.util.Arrays;

public class ExceptionInput {
    public static void checkNameLength(String[] names) {
        for (int i = 0; i < names.length; i++) {
            int len = names[i].length();
            if (len < Constants.MIN_NAME_LEN || len > Constants.MAX_NAME_LEN) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void checkRacingNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
