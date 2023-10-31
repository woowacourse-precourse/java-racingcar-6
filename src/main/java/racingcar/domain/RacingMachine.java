package racingcar.domain;

public class RacingMachine {

    private final Cars cars;
    private final int tryCount;

    public RacingMachine(Cars cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }
}
