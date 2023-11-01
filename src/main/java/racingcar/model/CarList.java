package racingcar.model;

import racingcar.Generator.NumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    private void validateLengthInRange(String input) {
        int length = input.length();
        if (length == 0 || length > 5) {
            throw new IllegalArgumentException("이름의 길이는 1 ~ 5 범위여야 합니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void doRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int number = numberGenerator.generateRandomNumber();
            moveCarWhenNumberFourOrAbove(car, number);
        }
    }

    private void moveCarWhenNumberFourOrAbove(Car car, int number) {
        if (isNumberFourOrAbove(number)) {
            car.move();
        }
    }

    public boolean isNumberFourOrAbove(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
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
