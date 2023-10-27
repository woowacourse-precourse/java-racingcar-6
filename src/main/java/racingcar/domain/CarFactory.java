package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> generateCar(String[] namesOfCars) {
        return Arrays.stream(namesOfCars)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
