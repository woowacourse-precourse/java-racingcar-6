package racingcar.domain;

import racingcar.util.RandomNumbersGenerator;
import racingcar.validation.InputValidation;
import racingcar.view.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private InputValidation inputValidation;

    public Cars(String[] names) {
        inputValidation = new InputValidation();
        inputValidation.hasDuplicateNames(names);
        this.cars = Arrays.stream(names)
                .map(this::createCar)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private Car createCar(String name) {
        inputValidation.isNameValid(name);
        return new Car(name);
    }

    public List<String> findWinners() {
        final Car winner = findFrontPosition();
        if (winner.getPosition() == 0) {
            return Collections.emptyList();
        }
        return findTiedWinners(winner);
    }

    private Car findFrontPosition() {
        Car maxPosition = cars.get(0); // 초기값으로 첫 번째 자동차를 선택
        for (Car car : cars) {
            if (car.compareTo(maxPosition) > 0) {
                maxPosition = car;
            }
        }
        return maxPosition;
    }

    private List<String> findTiedWinners(Car winner) {
        List<String> tiedWinners = new ArrayList<>();
        for (Car car : cars) {
            if (winner.isSamePosition(car)) {
                tiedWinners.add(car.getName());
            }
        }
        return tiedWinners;
    }

    public void moveCars() {
        RandomNumbersGenerator.randomNumberGenerator(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
