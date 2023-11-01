package racingcar.validator;

import java.util.Arrays;

public class CarInputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validateCars(String[] cars) {
        if (isCarNameDuplicate(cars) || isEmptyCars(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmptyCars(String[] cars) {
        return cars == null || cars.length == 0;
    }

    private static boolean isCarNameDuplicate(String[] cars) {
        return Arrays.stream(cars).distinct().toArray().length != cars.length;
    }

    public static void validateCar(String car) {
        if (!isPossibleCarNameLength(car) || isEmptyCarName(car)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isPossibleCarNameLength(String carName) {
        return carName.length() <= MAX_CAR_NAME_LENGTH;
    }

    private static boolean isEmptyCarName(String car) {
        return car == null || car.isBlank();
    }
}
