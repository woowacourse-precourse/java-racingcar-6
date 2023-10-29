package racingcar.domain;

import java.util.List;

public class CarFactory {
    private static final int MAX_NAME_LENGTH = 5;
    private CarFactory() {
    }

    public static Cars createRacingCars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .peek(CarFactory::verifyNameLength)
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    private static void verifyNameLength(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException();
        }
    }
}
