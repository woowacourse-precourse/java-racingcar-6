package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsNameValidator {
    public static void checkValidCarsName(List<String> cars) {
        checkEmptyCars(cars);
        checkDuplicateCars(cars);
    }

    private static void checkEmptyCars(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException(CarsNameErrorMessage.EMPTY_CARS.getMessage());
        }
    }

    private static void checkDuplicateCars(List<String> cars) {
        Set<String> set = new HashSet<>(cars);
        if (set.size() != cars.size()) {
            throw new IllegalArgumentException(CarsNameErrorMessage.DUPLICATE_CARS.getMessage());
        }
    }
}
