package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> generateCar(List<Name> namesOfCars) {
        return namesOfCars.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
