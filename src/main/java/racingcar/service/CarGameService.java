package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public interface CarGameService {
    void makeAndStoreCar(String[] names);
    void updateCar(List<Integer> randomNumbers);
    List<Integer> makeRandomNumbers();
    List<Car> getDuplicatedCars();
}
