package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private final List<Car> cars;

    public Game(List<String> carNames) {
        validateDuplicateCarName(carNames);
        cars = carNames.stream()
                .map(carName -> new Car(carName))
                .toList();
    }

    public void playOnce(NumberGenerator numberGenerator) {
        cars.forEach(car -> {
            car.moveOrStop(numberGenerator.generate());
        });
    }

    private Car findMaxPositionCar() {
        return cars.stream()
                .max(Car::compareToPosition)
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다"));
    }

    public List<Car> pickWinner() {
        Car maxPositionCar = findMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .toList();
    }

    public void validateDuplicateCarName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();

        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("중복된 차 이름이 있습니다");
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }
 }
