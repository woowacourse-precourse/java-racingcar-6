package racingcar.validator;


import java.util.Arrays;

import static racingcar.constant.ErrorMessage.CAR_NAME_IS_DUPLICATED;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_EMPTY;
import static racingcar.constant.ErrorMessage.CAR_NAME_IS_LONGER;

/**
 * 잘못된 예외 케이스
 * "1. faaaef,eerrwea,aa" -> 이름이 5글자가 넘음
 * "2. "asdf,,,ds,," -> 이름이 없는 차들이 발생
 */
public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public static void validate(String input) {
        String[] carNames = input.split(",");
        trim(carNames);

        if (hasLongerNames(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_IS_LONGER);
        }
        if (hasEmptyNames(carNames)) {
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

    private static boolean hasEmptyNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() == 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasLongerNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                return true;
            }
        }

        return false;
    }
}
