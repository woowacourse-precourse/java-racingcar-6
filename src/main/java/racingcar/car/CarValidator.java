package racingcar.car;

import java.util.HashSet;
import java.util.Set;
import racingcar.Constant;

public class CarValidator {

    public static boolean carValidation(String[] carNames) {
        try {
            validateName(carNames);
            duplicateName(carNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
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
