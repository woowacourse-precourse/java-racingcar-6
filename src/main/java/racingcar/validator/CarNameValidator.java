package racingcar.validator;

import java.util.List;

import static racingcar.constant.ErrorMessage.*;
import static racingcar.constant.NumberConstant.MAX_CAR_NAME_LENGTH;

public class CarNameValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR);
            }
            if (!isAlphabetic(name)) {
                throw new IllegalArgumentException(CAR_NAME_FORMAT_ERROR);
            }
        }
        if (hasDuplicates(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR);
        }
    }

    private static boolean isAlphabetic(String name) {
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicates(List<String> carNames) {
        return carNames.stream().distinct().count() != carNames.size();
    }
}