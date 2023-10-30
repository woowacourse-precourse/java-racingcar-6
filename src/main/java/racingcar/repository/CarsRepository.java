package racingcar.repository;

import racingcar.domain.Cars;

public class CarsRepository {
    private final Cars cars;

    public CarsRepository() {
        this.cars = Cars.create();
    }

    public String getName(int i) {
        return cars.getName(i);
    }

    public void initCars(String[] carArr) {
        cars.init(carArr);
    }

    public int size() {
        return cars.size();
    }

    public void plusNum(int i) {
        cars.plusNum(i);
    }

    public int getGameNum(int i) {
        return cars.getGameNum(i);
    }

    public int findMaxPosition() {
        return cars.findMaxPosition();
    }
}