package racingcar.repository;

import racingcar.entity.Car;

import java.util.List;

public interface CarRepository {
    void create(Car car);

    void update(Long carId);

    Car findById(Long carId);

    List<Car> findAll();
}
