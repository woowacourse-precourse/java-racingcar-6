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

}
