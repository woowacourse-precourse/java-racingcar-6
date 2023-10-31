package racingcar.service;

import racingcar.entity.Car;

import java.util.List;

public interface CarService {

    void createCar(String name);

    boolean isValidValue(int randomValue);

    void moveForward(Long carId);

    List<Car> getListOfCar();

    List<Car> getChampions();
}
