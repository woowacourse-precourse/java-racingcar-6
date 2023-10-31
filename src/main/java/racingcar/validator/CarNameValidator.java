package racingcar.validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.constants.MessageConstants;
import racingcar.constants.NumberConstants;
import racingcar.domain.Car;

public class CarNameValidator {

    public static void validateCarName(String carName) {
        checkLength(carName);
        checkBlank(carName);
    }

    public static void validateCarName(List<Car> carList) {
        checkDuplicateName(carList);
    }

    public static void checkLength(String carName) {
        if (carName.length() > NumberConstants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(MessageConstants.INVALID_CAR_NAME_FOR_LENGTH);
        }
    }

    public static void checkBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(MessageConstants.INVALID_CAR_NAME_FOR_BLANK);
        }
    }

    public static void checkDuplicateName(List<Car> carList) {
        Set<String> nameSet = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carList.size() != nameSet.size()) {
            throw new IllegalArgumentException(MessageConstants.INVALID_CAR_NAME_FOR_DUPLICATE_NAME);
        }
    }
}