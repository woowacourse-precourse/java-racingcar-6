package racingcar.utils;

import java.util.HashSet;
import java.util.List;
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
        return new HashSet<>(carList).size() != carList.size();
    }
}
