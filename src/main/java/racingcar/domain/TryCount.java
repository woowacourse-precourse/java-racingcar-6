package racingcar.domain;

public class TryCount {
    private int tryCount = 0;

    public TryCount(String tryCount) {
        this.tryCount = Integer.parseInt(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }
}
