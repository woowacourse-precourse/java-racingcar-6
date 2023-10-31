package racingcar.domain;

import static racingcar.domain.TryCntValidator.checkTryCount;

public class TryCnt {
    private int tryCnt;

    private TryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public static TryCnt createTryCnt(String tryCnt) {
        int num = checkTryCount(tryCnt);
        return new TryCnt(num);
    }

    public int tryValue() {
        return tryCnt;
    }
}
