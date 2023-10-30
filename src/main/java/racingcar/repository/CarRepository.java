package racingcar.repository;

import java.util.List;
import racingcar.domain.Car;

public interface CarRepository {
    void save(Car car);

    Car findById(Long carId);

    List<Car> findAll();
}
