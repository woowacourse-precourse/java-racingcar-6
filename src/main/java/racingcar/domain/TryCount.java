package racingcar.domain;

public class TryCount {

    private final int maxCount;
    private int currentCount = 0;

    public TryCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public void increaseCount() {
        currentCount++;
    }

    public boolean isProgress() {
        return currentCount < maxCount;
    }
}
