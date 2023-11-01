package racingcar.model;

public class TryCount {
    private static final Integer FINISH_COUNT = 0;

    private int count;

    public TryCount(int count) {
        TryValidator.validate(count);
        this.count = count;
    }

    public void decrease() {
        count--;
    }

    public boolean isAbleTry() {
        return count != FINISH_COUNT;
    }

    public int getCount() {
        return count;
    }
}
