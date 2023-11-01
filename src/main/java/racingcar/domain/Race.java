package racingcar.domain;

public class Race {
    private final Cars cars;
    private int runCount;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void run() {

    }

    public void setRunCount(int runCount) {
        this.runCount = runCount;
    }
}
