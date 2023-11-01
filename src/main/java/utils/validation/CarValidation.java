package utils.validation;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class CarValidation {
    private static final int CAR_NAME_MIN_SIZE = 2;
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final String CAR_NAME_PATTERN = "^[a-zA-Zㄱ-ㅎ가-힣]*$";

    public void carName(List<String> carNames) {
        carNames.forEach(
                carName -> {
                    carNamesSize(carName);
                    carNamePattern(carName);
                }
        );

        uniqueCarName(carNames);
    }

    private static void carNamesSize(String carName) {
        if (!(carName.length() >= CAR_NAME_MIN_SIZE && carName.length() <= CAR_NAME_MAX_SIZE)) {
            throw new IllegalArgumentException();
        }
    }

    private static void carNamePattern(String carName) {
        if (!Pattern.matches(CAR_NAME_PATTERN, carName)) {
            throw new IllegalArgumentException();
        }
    }

    private void uniqueCarName(List<String> carNames) {
        if (new HashSet<>(carNames).size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }

}
