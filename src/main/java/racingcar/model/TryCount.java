package racingcar.model;

public class TryCount {

    private int tryCount;

    public TryCount(int count) {
        verifyCount(count);
        tryCount = count;
    }

    private void verifyCount(int count) {
        if (count <= 0 || Integer.MAX_VALUE-1 < count) {
            throw new IllegalArgumentException();
        }
    }

    public int getCount() {
        return tryCount;
    }

    public void decreaseCount() {
        tryCount--;
    }

}
