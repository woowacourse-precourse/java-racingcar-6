package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(List<String> carNames) {
        validateNotEmpty(carNames);
        validateLength(carNames);
        validateDuplicates(carNames);
    }

    private static void validateNotEmpty(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 공백이면 안됩니다.");
            }
        }
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 공백이면 안됩니다.");
        }
    }

    private static void validateLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static void validateDuplicates(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
