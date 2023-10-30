package racingcar.domain.db;

import racingcar.domain.entity.CarEntity;

import java.util.ArrayList;
import java.util.List;

public class CarsData {
    private static List<CarEntity> cars = new ArrayList<>();

    public static List<CarEntity> getCars() {
        return cars;
    }

    public static void addCar(CarEntity car) {
        cars.add(car);
    }
}
