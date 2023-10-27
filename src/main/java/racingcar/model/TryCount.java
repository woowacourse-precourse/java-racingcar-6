package racingcar.model;

public class TryCount {

    private int tryCount;

    public TryCount(int count) {
        tryCount = count;
    }

    public int getCount() {
        return tryCount;
    }

    public void decreaseCount() {
        tryCount--;
    }
}
