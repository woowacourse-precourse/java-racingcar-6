package racingcar.repository;

import racingcar.domain.Car;

public interface CarRepository {
    void save(Car car);

    Car findById(Long carId);

}
