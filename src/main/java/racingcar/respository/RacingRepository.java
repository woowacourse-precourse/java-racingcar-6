package racingcar.respository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingRepository {

    private static Integer attempts = 0;
    private static List<Car> cars = new ArrayList<>();

    public Car saveCar(Car car) {
        cars.add(car);
        return car;
    }

    public void saveAttempts(Integer num) {
        attempts = num;
    }

    public List<Car> findCars() {
        return cars;
    }

    public Integer findAttempts() {
        return attempts;
    }
}
