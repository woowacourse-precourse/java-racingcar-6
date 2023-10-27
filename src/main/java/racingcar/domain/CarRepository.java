package racingcar.domain;

public class CarRepository {

    private static final CarRepository instance = new CarRepository();

    private Cars storedCars;

    public static CarRepository getInstance() {
        return instance;
    }

    public void save(final Cars cars) {
        storedCars = cars;
    }

    public Cars findCars() {
        return storedCars;
    }
}
