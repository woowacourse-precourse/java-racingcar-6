package racingcar.domain.car;

import java.util.List;

public interface CarFactory {
    int MAX_CAR_SIZE = 100;
    List<Car> createCars();
}
