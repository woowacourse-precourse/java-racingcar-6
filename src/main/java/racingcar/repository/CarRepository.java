package racingcar.repository;

import java.util.List;
import racingcar.domain.Car;

public interface CarRepository {
    void save(String name);

    List<Car> getCarList();
}
