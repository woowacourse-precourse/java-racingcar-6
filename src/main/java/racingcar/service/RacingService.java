package racingcar.service;

import java.util.List;

import racingcar.domain.Car;

public interface RacingService {
    void race(List<String> carList, String tryCount);

    void registerCars(List<String> carList);

    void driveAllCars(List<Car> carList);

    void writeRecord(List<Car> carList);

    List<String> getRecord();
}
