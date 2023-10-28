package racingcar.service;


public class RaceService {
    public void createCars(String carNamesInput) {
        validateCarNamesInput(carNamesInput);
    }

    public void validateCarNamesInput(String carNamesInput) {
        validateEmptyInput(carNamesInput);
        validateNullInput(carNamesInput);
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
}
