package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.game.car.Car;

public class GameProgress {
    private final List<Car> carsAfterTrial;

    private GameProgress(List<Car> carsAfterTrial) {
        this.carsAfterTrial = carsAfterTrial;
    }

    public static GameProgress of(List<Car> cars) {
        return new GameProgress(cars);
    }

    public String convertResultToString() {
        return carsAfterTrial.stream()
                .map(Car::showCurrentDisplacement)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
