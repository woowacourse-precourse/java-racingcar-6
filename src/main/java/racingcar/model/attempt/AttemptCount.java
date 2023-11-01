package racingcar.model.attempt;

public class AttemptCount {

    private int count;

    public AttemptCount(String attemptCountInput) {
        this.count = Integer.parseInt(attemptCountInput);
    }

    public boolean isNotZero() {
        return count != 0;
    }

    public void decrease() {
        count--;
    }
}
