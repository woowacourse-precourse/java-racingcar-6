package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(List<Car> cars) {
        valid(cars);
        return new Cars(cars);
    }

    private static void valid(List<Car> userInputList) {
        validLength(userInputList);
        validBlankString(userInputList);
    }

    private static void validLength(List<Car> userInputList) {
        boolean lengthOver = userInputList.stream().anyMatch(car -> car.getName().length() > 5);
        if (lengthOver) {
            throw new IllegalArgumentException();
        }
    }

    private static void validBlankString(List<Car> userInputList) {
        boolean isBlank = userInputList.stream().anyMatch(car -> car.getName().isBlank());
        if (isBlank) {
            throw new IllegalArgumentException();
        }
    }
}
