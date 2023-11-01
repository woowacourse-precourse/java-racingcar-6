package racingcar.util;

public class ValidateTryCount {

    private static int IsNumber(String InputTryCount) {

        int tryCount;

        try {
            tryCount = Integer.parseInt(InputTryCount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }

        return tryCount;
    }

    private static void IsPositive(int tryCount) {

        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1이상만 가능합니다.");
        }

    }

}
