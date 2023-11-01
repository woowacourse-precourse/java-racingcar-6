package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Name;

public class CarFactory {

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 10;


    public static Cars generate(List<String> carNames) {

        validateCarSize(carNames.size());

        List<Car> cars = carNames.stream()
                .map(Name::new)
                .map(Car::new)
                .collect(Collectors.toList());

        return Cars.create(cars);
    }

    private static void validateCarSize(int size) {
        if (size < MIN_CAR_COUNT || size > MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.CARS_SIZE);
        }
    }
}
