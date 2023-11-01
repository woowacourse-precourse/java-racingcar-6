package racingcar.service;

import racingcar.repository.Car;

import java.util.List;

public interface RacingService {
    void race();

    List<Car> winners();

    List<List<Car>> results();

    void generateCar(String name);
}
