package racingcar.domain;

public class TryCnt {

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
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
    private static void checkTryCntIsPositive(int tryCnt) {
        if (tryCnt <= 0) throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
    }
}
