package racingcar.domain;

import racingcar.exception.trycnt.TryCntIsNumberException;
import racingcar.exception.trycnt.TryCntIsPositiveException;

public class TryCnt {
    public static final int MIN_TRY_COUNT = 0;

    private int tryCnt;

    private TryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public TryCnt createTryCnt(String tryCnt) {
        int num = checkTryCount(tryCnt);
        return new TryCnt(num);
    }

    public static int checkTryCount(String tryCnt) {
        int num = checkTryCntIsNumber(tryCnt);
        checkTryCntIsPositive(num);
        return  num;
    }

    private static int checkTryCntIsNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new TryCntIsNumberException();
        }
    }
    private static void checkTryCntIsPositive(int tryCnt) {
        if (tryCnt <= MIN_TRY_COUNT) throw new TryCntIsPositiveException();
    }
}
