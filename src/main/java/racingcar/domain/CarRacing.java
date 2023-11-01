package racingcar.domain;

import racingcar.util.Validation;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacing {

    private List<Car> cars;
    private int farthestPosition;

    public CarRacing(List<String> names) {
        Validation.validateCarNames(names);
        cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void oneRacing() {
        moveCars();
        updateFarthestPosition();
    }

    private void moveCars() {
        cars.forEach(car -> car.move(generateRandomCarState()));
    }

    private CarState generateRandomCarState() {
        return RandomCarStateGenerator.generate();
    }

    private void updateFarthestPosition() {
        cars.stream()
                .map(Car::getPosition)
                .filter(position -> position > farthestPosition)
                .forEach(position -> farthestPosition = position);
    }

    public RacingResultDTO toDTO() {
        return new RacingResultDTO(getNames(), getPositions());
    }

    private List<String> getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == farthestPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}