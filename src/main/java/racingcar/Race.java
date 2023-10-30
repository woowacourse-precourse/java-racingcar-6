package racingcar;

import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private List<Car> winners = new ArrayList<>();


    public Race(List<Car> cars) {
        this.cars = cars;
    }

    public boolean canCarGoForward() {
        int randomNumber = RandomNumberGenerator.getNumber();

        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public void tryMoveCar(Car car) {
        if (canCarGoForward()) {
            car.goForward();
        }
    }

    public void runOneRound() {
        for (Car car : cars) {
            tryMoveCar(car);
        }
    }

    public void setWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        winners = cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }


}
