package racingcar.domain;

public class CarsRepository {

    private CarsRepository() {
    }

    private static final CarsRepository instance = new CarsRepository();

    private Cars storedCars;

    public static CarsRepository getInstance() {
        return instance;
    }

    public void save(final Cars cars) {
        storedCars = cars;
    }

    public Cars findCars() {
        return storedCars;
    }
}
