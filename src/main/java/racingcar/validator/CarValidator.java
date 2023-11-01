package racingcar.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarValidator {
    private final static int LENGTH_STANDARD = 5;

    public void checkInput(String[] carNameInput) {
        checkCarCount(carNameInput);
        checkCarName(carNameInput);
        checkDuplicate(carNameInput);
    }

    private void checkCarCount(String[] carNameInput) {
        if (carNameInput.length == 0) {
            throw new IllegalArgumentException("At least one car required");
        }
    }

    private void checkCarName(String[] carNames) {
        for (String carName : carNames) {
            checkLength(carName);
            checkNonBlank(carName);
        }
    }

    private void checkLength(String name) {
        if (name.length() > LENGTH_STANDARD) {
            throw new IllegalArgumentException(String.format("Length must be less or equal than %d", LENGTH_STANDARD));
        }
    }

    private void checkNonBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Car name cannot be blank");
        }
    }

    private void checkDuplicate(String[] carNames) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(carNames));
        if (carNames.length != carNameSet.size()) {
            throw new IllegalArgumentException("Name must not be duplicated");
        }
    }
}
