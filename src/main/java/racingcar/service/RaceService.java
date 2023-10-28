package racingcar.service;


public class RaceService {
    public void createCars(String carNamesInput) {
        validateCarNamesInput(carNamesInput);
    }

    public void validateCarNamesInput(String carNamesInput) {
        validateEmptyInput(carNamesInput);
    }

    private void validateEmptyInput(String carNamesInput) {
        if (carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

}
