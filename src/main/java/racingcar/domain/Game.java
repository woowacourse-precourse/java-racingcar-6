package racingcar.domain;

import java.util.List;

public class Game {

    private final List<Car> cars;

    public Game(List<Car> cars) {
        validateDuplicateCarName(cars);
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
        Car maxPositionCar = findMaxPositionCar();

        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .toList();
    }

    public void validateDuplicateCarName(List<Car> cars) {
        boolean isSameNameExists = cars.stream()
                .map(Car::toString)
                .distinct()
                .count() < cars.size();

        if (isSameNameExists) {
            throw new IllegalArgumentException("같은 이름의 자동차가 있습니다");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
 }
