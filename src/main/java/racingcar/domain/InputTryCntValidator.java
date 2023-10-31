package racingcar.domain;

import racingcar.exception.trycnt.TryCntIsNumberException;
import racingcar.exception.trycnt.TryCntIsPositiveException;

public class InputTryCntValidator {
    public static final int MIN_TRY_COUNT = 0;

    public static int checkTryCount(String tryCnt) {
        int num = checkTryCntIsNumber(tryCnt);
        checkTryCntIsPositive(num);
        return num;
    }

    private static int checkTryCntIsNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new TryCntIsNumberException();
        }
    }

    private static void checkTryCntIsPositive(int tryCnt) {
        if (tryCnt <= MIN_TRY_COUNT) {
            throw new TryCntIsPositiveException();
        }
    }
}
