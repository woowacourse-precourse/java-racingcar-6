package racingcar.domain;

import racingcar.util.CarNamesValidator;

import java.util.List;

public class CarsDto {
    private final List<String> carNames;

    public CarsDto(String inputtedCarNames) {
        this.carNames = validateInputtedCarNames(inputtedCarNames);
    }

    private List<String> validateInputtedCarNames(String inputtedCarNames) {
        return CarNamesValidator.getValidatedCarNamesList(inputtedCarNames);
    }

    public String getSingleCarName(int index) {
        return carNames.get(index);
    }

    public int getNumberOfCars() {
        return carNames.size();
    }
}
