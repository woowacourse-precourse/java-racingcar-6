package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Game {
    private final List<Car> cars;

    public Game() {
        this.cars = new ArrayList<>();
    }

    public void saveCars(List<String> carNames) {
        carNames.stream()
                .map(carName -> new Car(carName, 0))
                .forEach(cars::add);
    }

    public List<Car> playOnce() {
        cars.forEach(Car::conductAction);
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getFinalists() {
        int winningDisplacement = cars.stream()
                .map(Car::getDisplacement)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("저장된 자동차가 없습니다"));

        return cars.stream()
                .filter(car -> car.getDisplacement() == winningDisplacement)
                .toList();
    }
}
