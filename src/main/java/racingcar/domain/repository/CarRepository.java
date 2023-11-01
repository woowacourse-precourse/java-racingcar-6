package racingcar.domain.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarRepository {
    private static List<Car> cars = new ArrayList<>();

    public static List<Car> cars() {
        return cars;
    }

    public static void add(Car car) {
        cars.add(car);
    }
}
