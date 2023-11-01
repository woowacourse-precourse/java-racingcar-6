package racingcar.domain;

public class AttemptCount {
    private static final int DEFAULT = 0;

    private int count;

    public AttemptCount() {
        this.count = DEFAULT;
    }

    public boolean isOver(int count) {
        return this.count != count;
    }

    public void increaseCount() {
        count++;
    }
}
