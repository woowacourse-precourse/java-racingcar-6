package racingcar.service;

import racingcar.repository.Car;

import java.util.List;

public interface RacingService {
    public void race();
    public List<Car> winners();
    public List<List<Car>> results();

    public void generateCar(String name);
}
