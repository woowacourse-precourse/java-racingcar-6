package racingcar.domain.gamemanager.service;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    public void saveCar(String carNames) {
        createCar(carNames);

        save();
    }

    private List<Car> createCar(String carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        Arrays.stream(carNames.split(","))
                .forEach(carName -> cars.add(new Car(carName)));

        return cars;
    }
}
