package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.CarRaceConstant;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomGenerator;

/**
 * 애플리케이션 로직을 담당하는 클래스
 */
public class CarRaceService {

    private final Cars cars;

    public CarRaceService() {
        this.cars = new Cars();
    }


    public void addCars(String input) {
        cars.saveCars(input);
    }

    public void moveCars() {
        for (int i = 0; i < cars.size(); i++) {
            if (shouldMoveForward()) {
                cars.moveCar(i);
            }
        }
    }

    public boolean shouldMoveForward() {
        int randomNumber = RandomGenerator.createRandomNumber();
        return randomNumber >= CarRaceConstant.MOVE_MIN_VALUE.getConstant();
    }

    public List<String> getCarsName() {
        return cars.getNames();
    }

    public List<Integer> getCarsLocation() {
        return cars.getLocations();
    }

    public List<String> getWinnersName() {
        List<Car> winnersCar = cars.getCarsByLocation(cars.getMaxLocation());
        return winnersCar.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
