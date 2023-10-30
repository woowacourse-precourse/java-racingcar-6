package racingcar.domain;

public class AdvanceCount {
    private static final int ADVANCE_COUNT = 1;
    public static int maxCount = 0;
    private int count;

    public void accumulate() {
        this.count += ADVANCE_COUNT;
        calculateMaxCount();
    }

    public int getCount() {
        return this.count;
    }

    private void calculateMaxCount() {
        if (this.count > maxCount) {
            maxCount = this.count;
        }
    }
}
