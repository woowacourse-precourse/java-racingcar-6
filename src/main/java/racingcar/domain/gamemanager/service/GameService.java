package racingcar.domain.gamemanager.service;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Arrays;

public class GameService {

    public void saveCar(String carNames) {
        createCar(carNames);

        save();
    }

    private void createCar(String carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }
}
