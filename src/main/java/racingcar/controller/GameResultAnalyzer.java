package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class GameResultAnalyzer {
    private GameResultAnalyzer() {
    }

    public static List<Car> determineWinners(List<Car> cars) {
        int maxDistance = cars.stream()
                .mapToInt(Car::getForwardDistance)
                .max()
                .orElse(0);

        List<Car> winningCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getForwardDistance() == maxDistance) {
                winningCars.add(car);
            }
        }
        return winningCars;
    }
}
