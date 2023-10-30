package racingcar.repository;

import racingcar.domain.Cars;

public class CarsRepository {
    private final Cars cars;

    public CarsRepository() {
        this.cars = new Cars();
    }

    public void initCars(String[] carArr) {
        cars.init(carArr);
    }

    public Cars getCars() {
        return cars;
    }
}