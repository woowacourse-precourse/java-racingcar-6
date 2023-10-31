package racingcar.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarCreator {

    private static final String DELIMITER = ",";
    private static final int ONE_TIME = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static List<String> splitCarNamesString(String carNamesString) {
        return arrayToList(carNamesString.split(DELIMITER));
    }

    public static void validateCarNames(List<String> carNames) {
        carNames.forEach(car -> validateCarName(car, carNames));
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(CarCreator::createCar)
                .toList();
    }

    private static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    private static void validateCarName(String carName, List<String> carNames) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH
                || Collections.frequency(carNames, carName) > ONE_TIME) {
            throw new IllegalArgumentException();
        }
    }

    private static Car createCar(String carName) {
        return Car.withName(carName);
    }
}
