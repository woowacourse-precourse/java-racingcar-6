package util;

import java.util.List;

public class CarsNameValidator {
    public static void checkValidCarsName(List<String> cars) {

    }

    private static void checkEmptyCars(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
