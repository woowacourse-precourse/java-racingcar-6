package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int attempts;
    private int currentRound;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
        this.currentRound = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void startRound() {
        for (Car car : cars) {
            car.move();
        }
        currentRound++;
    }

    public boolean hasMoreRounds() {
        return currentRound < attempts;
    }

    public List<String> findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
