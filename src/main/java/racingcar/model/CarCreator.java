package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarCreator {

    public static List<String> splitCarNamesString(String carNamesString) {
        return arrayToList(carNamesString.split(","));
    }

    public static void validateCarNames(List<String> carNames) {
        carNames.forEach(CarCreator::validateCarName);
    }

    public static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(CarCreator::createCar)
                .toList();
    }

    private static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    private static void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static Car createCar(String carName) {
        return new Car(carName);
    }
}
