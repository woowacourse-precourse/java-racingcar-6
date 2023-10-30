package racingcar.domain;

public class TryCount {
    private final int tryCount;

    public TryCount(String tryCount) {
        this.tryCount = Integer.parseInt(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}
