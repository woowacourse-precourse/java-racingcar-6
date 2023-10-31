package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import racingcar.exception.car.BlankCarNameException;
import racingcar.exception.car.CarNameNumberLimitException;
import racingcar.exception.car.DuplicateCarNameException;

public class InputCarValidator {
    public static final int CAR_NAME_NUMBERS_LIMIT_SIZE = 5;

    public static String[] carsByStringToArray(String inputAllCars) {
        return inputAllCars.split(",");
    }

    public static Set<String> checkDuplicateCarName(String[] cars) {
        Set<String> carSet = new HashSet<>();
        Arrays.stream(cars)
                .peek(car -> validateDuplicate(car, carSet))
                .forEach(carSet::add);
        return carSet;
    }

    public static void validateDuplicate(String car, Set<String> carSet) {
        if (carSet.contains(car)) {
            throw new DuplicateCarNameException();
        }
    }

    public static void checkOver5Letters(String name) {
        if (name.length() > CAR_NAME_NUMBERS_LIMIT_SIZE) {
            throw new CarNameNumberLimitException();
        }

    }

    public static void checkCarWithBlank(String name) {
        if (name.isBlank()) {
            throw new BlankCarNameException();
        }
    }
}
