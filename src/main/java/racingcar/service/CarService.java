package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface CarService {

    void join(Car car);

    Car findCarById(Long id);

    List<Car> findAllCars();

    void moveCarToForward(Long id);
}
