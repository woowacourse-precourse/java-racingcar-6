package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars simulateNextRound(RandomNumberGenerator generator) {
        return new Cars(
                cars.stream()
                        .map(car -> car.move(generator.getRandomNumber()))
                        .collect(Collectors.toList())
        );
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        Car highestCar = getHighestPositionCar();

        for (Car car : cars) {
            if (car.isSamePosition(highestCar)) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private Car getHighestPositionCar() {
        Car highestCar = cars.get(0);
        for (Car car : cars) {
            if (car.getPosition() > highestCar.getPosition()){
                highestCar = car;
            }
        }
        return highestCar;
    }
}
