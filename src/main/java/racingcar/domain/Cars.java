package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void move() {
        cars.stream()
                .filter(car -> car.canGo(RandomNumberGenerator.makeRandomNumber()))
                .forEach(Car::go);
    }

    public List<String> getWinner() {
        int winnerPosition = getWinnerPosition();

        return cars.stream()
                .filter(car -> car.isWinner(winnerPosition))
                .map(Car::getName)
                .toList();
    }

    private int getWinnerPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .reduce(0, Integer::max);
    }

    public List<Car> getCars() {
        return cars;
    }
}
