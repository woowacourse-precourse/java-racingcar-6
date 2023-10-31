package racingcar.domain.car.carfactory;

import java.util.List;
import racingcar.domain.car.Car;

public interface CarFactory {
    int MAX_CAR_SIZE = 100;
    List<Car> createCars();
}
