package racingcar.repository;

import racingcar.domain.Cars;

public class CarsRepository {
    private final Cars cars;

    public CarsRepository() {
        this.cars = Cars.create();
    }

    public void initCars(String[] carArr) {
        cars.init(carArr);
    }

    public String getName(int i) {
        return cars.getName(i);
    }

    public int getPosition(int i) {
        return cars.getPosition(i);
    }

    public int size() {
        return cars.size();
    }

    public void plusNum(int i, int random) {
        cars.plusNum(i, random);
    }

    public int findMaxPosition() {
        return cars.findMaxPosition();
    }
}