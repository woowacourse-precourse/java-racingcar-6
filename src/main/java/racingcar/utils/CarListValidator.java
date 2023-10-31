package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class CarListValidator {

    public static void validate(List<Car> carList) {
        if (isCarAlone(carList) || isCarDuplicated(carList)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCarAlone(List<Car> carList) {
        return carList.size() <= 1;
    }

    private static boolean isCarDuplicated(List<Car> carList) {

        List<String> carNames = carList.stream().map(Car::getName).collect(Collectors.toList());

        return new HashSet<>(carNames).size() != carNames.size();
    }
}
