package racingcar.domain;

public class TryCnt {

    private int tryCnt;


    public static void checkTryCount(String tryCnt) {
        int num = checkTryCntIsNumber(tryCnt);
        checkTryCntIsPositive(num);
    }

    private static int checkTryCntIsNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
    private static void checkTryCntIsPositive(int tryCnt) {
        if (tryCnt <= 0) throw new IllegalArgumentException("시도 횟수는 최소 1번 이상이어야 합니다.");
    }
}
