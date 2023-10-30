package racingcar.domain;

public class AttemptCount {
    private int count;

    public AttemptCount() {
        this.count = 0;
    }

    public boolean isOver(int count) {
        return this.count != count;
    }

    public void increaseCount() {
        count ++;
    }
}
