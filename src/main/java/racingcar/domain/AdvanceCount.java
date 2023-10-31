package racingcar.domain;

public class AdvanceCount {
    private static final int ADVANCE_COUNT = 1;
    public static int maxCount = 0;
    private int count;

    public void accumulate() {
        this.count += ADVANCE_COUNT;
        compareMaxCount();
    }

    public int getCount() {
        return this.count;
    }

    private void compareMaxCount() {
        if (this.count > maxCount) {
            maxCount = this.count;
        }
    }
}
