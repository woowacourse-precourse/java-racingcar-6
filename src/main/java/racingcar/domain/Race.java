package racingcar.domain;

public class Race {
    private final Cars cars;
    private final int count;

    public Race(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }
}
