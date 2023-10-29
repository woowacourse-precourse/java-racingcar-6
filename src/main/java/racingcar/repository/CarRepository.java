package racingcar.repository;

import racingcar.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Car save(Car car);

    Optional<Car> findById(Long id); // 없으면 null로 반환하는데 요즘은 optional로 묶어버림

    Optional<Car> findByName(String name);

    List<Car> findAll();
}
