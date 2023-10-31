package racingcar.domain;

import racingcar.exception.trycnt.TryCntIsNumberException;
import racingcar.exception.trycnt.TryCntIsPositiveException;

import static racingcar.domain.constants.Constants.MIN_TRY_COUNT;

public class TryCntValidator {

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
