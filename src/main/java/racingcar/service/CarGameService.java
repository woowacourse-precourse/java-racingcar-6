package racingcar.service;

import java.util.Map;

public interface CarGameService {
    void makeAndStoreCar(String[] names);
    Map<String, Integer> updateCar();
}
