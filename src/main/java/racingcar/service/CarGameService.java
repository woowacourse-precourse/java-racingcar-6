package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public interface CarGameService {
    void makeAndStoreCar(String[] names);
    List<Car> updateCar();
    List<Integer> makeRandomNumbers();
}
