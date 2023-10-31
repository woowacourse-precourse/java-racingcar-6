package racingcar.model;

public class TryCount {
    private int tryCount;

    public TryCount(String inputTryCount) {
        this.tryCount = convertStrToInt(inputTryCount);
        validatePositiveNumber(tryCount);
    }

    private int convertStrToInt(String inputTryCount) {
        try {
            return Integer.parseInt(inputTryCount);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }

    private void validatePositiveNumber(int countNum) {
        if (countNum <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
