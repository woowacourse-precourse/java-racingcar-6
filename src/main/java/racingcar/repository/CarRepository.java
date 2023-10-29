package racingcar.repository;

import java.util.List;
import java.util.Optional;
import racingcar.domain.Car;

public interface CarRepository {

    Car save(Car car);
    Car findById(Long id);
    Car findByName(String name);
    List<Car> findAll();
}
