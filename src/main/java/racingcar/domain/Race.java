package racingcar.domain;

public class Race {
    private final Cars cars;
    private int runCount;
    private int maxDistance;
    private Cars winnerCars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void run() {
        execute();
        calculateMaxDistance();
        judgeWinner();
        showWinner();
    }

    private void execute() {
        cars.executeRound(runCount);
    }

    public void setRunCount(int runCount) {
        this.runCount = runCount;
    }

    private void calculateMaxDistance() {
        maxDistance = cars.determineMaxDistance();
    }

    private void judgeWinner() {
        winnerCars = this.cars.determineWinner(maxDistance);
    }

    private void showWinner() {
        winnerCars.showBestDriver();
    }
}
