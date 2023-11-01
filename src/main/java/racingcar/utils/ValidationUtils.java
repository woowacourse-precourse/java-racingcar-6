package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class ValidationUtils {
    public static void validateCars(List<Car> cars) {
        validateCarNamesLength(cars);
        validateUniqueCarNames(cars);
    }

    public static void validateRound(String round) {
        validateRoundIsNumber(round);
        validateRoundIsPositive(round);
    }

    public static void validateInputExist(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateCarNamesLength(List<Car> cars) {
        for (Car car : cars) {
            if (!car.isNameLengthValid()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateUniqueCarNames(List<Car> cars) {
        Set<String> carNames = new HashSet<>();
        for (Car car : cars) {
            if (!carNames.add(car.getName())) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void validateRoundIsNumber(String round) {
        if (!round.matches("^\\d+$")) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRoundIsPositive(String round) {
        if (Integer.parseInt(round) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
