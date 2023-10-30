package racingcar.service;

public class TrialCounter {

    private int count;

    public void initTrialCount(int count) {
        this.count = count;
    }

    public boolean isFinish() {
        return count == 0;
    }

    public void takeTrial() {
        count--;
    }
}