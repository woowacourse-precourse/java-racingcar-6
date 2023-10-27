package racingcar.domain.car.dao;

import racingcar.domain.car.Car;

import java.util.HashMap;

public class CarRepository {

    private static Long CarId = 0L;
    private HashMap<Long, Car> carDatabase;

    public void save(Car car) {
        carDatabase.put(CarId, car);
        CarId++;
    }

}
