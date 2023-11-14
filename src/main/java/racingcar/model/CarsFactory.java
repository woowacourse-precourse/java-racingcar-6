package racingcar.model;

import java.util.Arrays;

public class CarsFactory {
    private static final String DELIMITER = ",";

    public static Cars createCars(String cars) {
        return new Cars(Arrays.stream(cars.split(DELIMITER))
                .map(Car::new)
                .toList());
    }
}
