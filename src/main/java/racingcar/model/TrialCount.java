package racingcar.model;

public class TrialCount {

    private int count;

    public TrialCount(int count) {
        this.count = count;
    }

    public void countDown() {
        this.count--;
    }
}
