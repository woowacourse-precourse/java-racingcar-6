package racingcar.model;

public class TryCount {
    private final int tryCount;

    public TryCount(String stringTryCount) {
        this.tryCount = convertStringToInt(stringTryCount);
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
