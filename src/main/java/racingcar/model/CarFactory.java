package racingcar.model;

import java.util.List;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> generateCar(List<Name> namesOfCars) {
        return namesOfCars.stream()
                .map(carName -> new Car(carName))
                .toList();
    }
}
