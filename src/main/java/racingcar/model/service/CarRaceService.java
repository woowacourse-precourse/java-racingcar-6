package racingcar.model.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.constant.CarRaceConstant;
import racingcar.model.domain.Car;
import racingcar.model.domain.CarManager;
import racingcar.model.domain.RandomGenerator;

public class CarRaceService {

    private final CarManager carManager;

    public CarRaceService() {
        this.carManager = new CarManager();
    }

    public void addCars(String input) {
        carManager.saveCars(input);
    }

    public void moveCars() {
        for (int i = 0; i < carManager.size(); i++) {
            if (shouldMoveForward()) {
                carManager.moveCar(i);
            }
        }
    }

    private boolean shouldMoveForward() {
        int randomNumber = RandomGenerator.createRandomNumber();
        return randomNumber >= CarRaceConstant.MOVE_MIN_VALUE.getConstant();
    }

    public List<String> getCarsName() {
        return carManager.getNames();
    }

    public List<Integer> getCarsLocation() {
        return carManager.getLocations();
    }

    public List<String> getWinnersName() {
        List<Car> winnersCar = carManager.getCarsByLocation(carManager.getMaxLocation());
        return winnersCar.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}