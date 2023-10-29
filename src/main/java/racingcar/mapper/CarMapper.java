package racingcar.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class CarMapper {
    private static final String DELIMITER = ",";

    private CarMapper () {}

    public static List<Car> convertToCars(String cars) {
        String[] tokens = cars.split(DELIMITER);
        return Arrays.stream(tokens)
                .map(name -> new Car(name))
                .collect(Collectors.toList());
    }
}
