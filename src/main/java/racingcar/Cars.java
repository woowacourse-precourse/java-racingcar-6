package racingcar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    Cars(String carNames) {
        validateNullOrEmpty(carNames);
        validateLastCharComma(carNames);
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        validateDuplicate();
    }

    private void validateNullOrEmpty(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.EMPTY);
        }
    }

    private void validateLastCharComma(String carNames) {
        if (carNames.charAt(carNames.length() - 1) == ',') {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.DELIMITER_END);
        }
    }

    private void validateDuplicate() {
        int distinctSize = cars.stream()
                .distinct()
                .toList()
                .size();

        if (cars.size() != distinctSize) {
            throw new IllegalArgumentException(UserInputMissExceptionMessage.DUPLICATE);
        }
    }

    public void race() {
        for (Car car : cars) {
            car.go(new RandomNumber());
        }
    }

    public void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public String getWinner() {
        List<Car> sortCars = cars.stream()
                .sorted(Comparator.comparingInt(Car::getDistance))
                .toList();
        int maxDistance = sortCars.get(sortCars.size() - 1)
                .getDistance();

        return sortCars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

}
