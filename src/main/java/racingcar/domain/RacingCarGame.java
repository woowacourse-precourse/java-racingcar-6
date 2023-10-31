package racingcar.domain;

public class RacingCarGame {

    private final Cars cars;
    private final TryCount tryCount;

    public RacingCarGame(Names names, TryCount tryCount) {
        this.cars = new Cars(names);
        this.tryCount = tryCount;
    }

    public void race() {
        cars.race();
        tryCount.increaseCount();
    }

    public Cars getRacingResult() {
        return cars;
    }

    public Names getWinner() {
        return cars.getWinner();
    }

    public boolean isProgress() {
        return tryCount.isProgress();
    }
}
