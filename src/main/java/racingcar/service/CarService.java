package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

public class CarService {

    private final CarRepository carRepository = new CarRepository();

    public void save(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(carRepository::save);
    }
}
