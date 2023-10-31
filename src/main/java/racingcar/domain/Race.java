package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private int rounds;
    private int currentRound = 0;

    public Race(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void raceRound() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
        }
        currentRound++;
    }

    public boolean isFinished() {
        return currentRound >= rounds;
    }

    public List<Car> getWinner() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isPositionFurther(maxPositionCar))
                .collect(Collectors.toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream().reduce(this::compareCarPosition).orElse(null);
    }

    private Car compareCarPosition(Car car1, Car car2) {
        if (car1.isPositionFurther(car2)) {
            return car1;
        }
        return car2;
    }
}
