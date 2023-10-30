package racingcar.controller;

import static racingcar.util.RandomNumber.randomNumber;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarController {

    public List<Car> initializeCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, 0))
                .collect(Collectors.toList());
    }

    public void moveCarForward(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = randomNumber();
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
