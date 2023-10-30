package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public interface CarGameService {
    void updateCar(List<Integer> randomNumbers);
    List<Car> getDuplicatedCars();
}
