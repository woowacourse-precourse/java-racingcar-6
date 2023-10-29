package racingcar.service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Cars;

public class RaceService {
    public void createCars(String carNamesInput) {
        List<String> carNames = validateCarNamesInput(carNamesInput);
        Cars cars = new Cars(carNames);
    }

    public List<String> validateCarNamesInput(String carNamesInput) {
        validateEmptyInput(carNamesInput);
        validateNullInput(carNamesInput);
        List<String> carNames = Arrays.stream(carNamesInput.split(","))
                .map(String::trim).toList();
        validateLengthInput(carNames);
        validateDuplicateInput(carNames);
        return carNames;
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
                .anyMatch(carName -> carName.length() > 5);

        if (isInvalidCarName) {
            throw new IllegalArgumentException();
        }
    }


    private void validateDuplicateInput(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException();
        }
    }
}
