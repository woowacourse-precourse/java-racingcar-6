package racingcar.service;


import java.util.Arrays;
import java.util.List;

public class RaceService {
    public void createCars(String carNamesInput) {
        validateCarNamesInput(carNamesInput);
    }

    public void validateCarNamesInput(String carNamesInput) {
        validateEmptyInput(carNamesInput);
        validateNullInput(carNamesInput);
        List<String> carNames = Arrays.asList(carNamesInput.split(","));
        validateLengthInput(carNames);
    }

    private void validateEmptyInput(String carNamesInput) {
        if (carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNullInput(String carNamesInput) {
        if (carNamesInput == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLengthInput(List<String> carNames) {
        boolean isInvalidCarName = carNames
                .stream()
                .anyMatch(carName -> carName.trim().length() > 5);

        if (isInvalidCarName) {
            throw new IllegalArgumentException();
        }
    }
}
