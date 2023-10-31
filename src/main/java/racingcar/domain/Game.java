package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public Game(List<Car> cars) {
        this.cars = cars;
    }

    public void playOnce(NumberGenerator numberGenerator) {
        cars.forEach(car -> {
            car.moveOrStop(numberGenerator.generate());
        });
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다"));
    }

    public List<Car> pickWinner() {
        return cars.stream()
                .filter(car -> car.isSamePosition(findMaxPositionCar()))
                .toList();
    }
}
