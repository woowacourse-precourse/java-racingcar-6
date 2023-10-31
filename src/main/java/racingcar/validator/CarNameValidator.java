package racingcar.validator;


import java.util.Arrays;

import static racingcar.constant.ConstantNumber.MAX_CAR_NAME_LENGTH;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_DUPLICATED;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;

public class CarNameValidator {

    public static void validate(String input) {
        String[] carNames = input.split(",");
        trim(carNames);

        if (hasLongerName(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_IS_LONGER);
        }
        if (hasEmptyName(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_IS_EMPTY);
        }
        if (hasDuplicatedName(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_IS_DUPLICATED);
        }
    }

    private static void trim(String[] carNames) {
        for (int i = 0; i < carNames.length; i++) {
            carNames[i] = carNames[i].trim();
        }
    }

    private static boolean hasDuplicatedName(String[] carNames) {
        return carNames.length != Arrays.stream(carNames)
                .distinct()
                .count();
    }

    private static boolean hasEmptyName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() == 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasLongerName(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                return true;
            }
        }

        return false;
    }
}
