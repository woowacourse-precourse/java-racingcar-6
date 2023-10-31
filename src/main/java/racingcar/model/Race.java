package racingcar.model;

public class Race {

    private final Cars cars;

    public Race(Cars cars) {

        this.cars = cars;
    }

    public void start(CarMovementStrategy carMovementStrategy) {

        this.cars.move(carMovementStrategy);
    }
}
