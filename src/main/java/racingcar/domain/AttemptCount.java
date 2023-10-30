package racingcar.domain;

public class AttemptCount {
    private int count;

    public AttemptCount(int count) {
        this.count = count;
    }

    public boolean isNotFinish() {
        return count != 0;
    }

    public void decreaseCount() {
        count --;
    }
}
