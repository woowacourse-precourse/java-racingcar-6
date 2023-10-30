package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRecord;

public class CarRepository {
    public static int IDENTITY_NUMBER = 0;
    private static List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }
}
