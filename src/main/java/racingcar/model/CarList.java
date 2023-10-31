package racingcar.model;

import racingcar.Generator.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.Validator.Validator.validateLengthInRange;
import static racingcar.Validator.Validator.validateNotBlank;

public class CarList {
    private final List<Car> cars;

    public CarList(String allCarNames) {
        this.cars = Arrays.stream(allCarNames.split(","))
                .map(this::createCar)
                .collect(Collectors.toList());
    }

    private Car createCar(String name) {
        validateNotBlank(name);
        validateLengthInRange(name);
        return new Car(name);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void doRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int number = numberGenerator.generateRandomNumber();
            moveCarWhenNumberFourOrAbove(numberGenerator, car, number);
        }
    }

    private void moveCarWhenNumberFourOrAbove(NumberGenerator numberGenerator, Car car, int number) {
        if (isNumberFourOrAbove(numberGenerator, number)) {
            car.move();
        }
    }

    private boolean isNumberFourOrAbove(NumberGenerator numberGenerator, int number) {
        return numberGenerator.isFourOrAbove(number);
    }

    public int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition)
                .max().orElse(0);
    }

    public List<String> findWinners(int maxPosition) {
        return cars.stream().filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
