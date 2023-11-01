package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";
    private final List<Car> cars = new ArrayList<>();

    private Cars(List<String> carNames) {
        for (String carName : carNames) {
            this.cars.add(Car.create(carName));
        }
    }

    public static Cars create(String carNameString) {
        String[] carNamesWithBlank = splitCarNames(carNameString);
        List<String> trimmedCarNames = trimCarNames(carNamesWithBlank);
        checkDuplicate(trimmedCarNames);
        return new Cars(trimmedCarNames);
    }

    private static String[] splitCarNames(String carNames) {
        return carNames.split(CAR_NAME_DELIMITER);
    }

    private static List<String> trimCarNames(String[] splittedCarNames) {
        return Arrays.stream(splittedCarNames).map(String::trim).toList();
    }

    private static void checkDuplicate(List<String> carNames) {
        HashSet<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException();
            }
            carNameSet.add(carName);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
