package racingcar.model;

public class TrialCount {

    private static final int NO_COUNT = 0;

    private int count;

    public TrialCount(int count) {
        this.count = count;
    }

    public void countDown() {
        this.count--;
    }

    public boolean hasNoCount() {
        return this.count == NO_COUNT;
    }

    public boolean hasCount() {
        return this.count != NO_COUNT;
    }
}
