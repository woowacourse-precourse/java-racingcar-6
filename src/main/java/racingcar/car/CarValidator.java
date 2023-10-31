package racingcar.car;

import java.util.HashSet;
import java.util.Set;
import racingcar.Constant;

public class CarValidator {

    public static void carValidation(String[] carNames) {
        validateName(carNames);
        duplicateName(carNames);
    }

    private static void validateName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() < Constant.MINIMUM_NAME_NUMBER
                    || carName.length() > Constant.MAXIMUM_NAME_NUMBER) {
                throw new IllegalArgumentException(Constant.NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private static void duplicateName(String[] carNames) {
        Set<String> cars = new HashSet<>();
        for (String carName : carNames) {
            if (!cars.add(carName)) {
                throw new IllegalArgumentException(Constant.NAME_DUPLICATE_ERROR_MESSAGE);
            }
        }
    }
}
