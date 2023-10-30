package racingcar.domain;

import java.util.List;

public class CarsDto {
    private final List<String> carNames;

    public CarsDto(List<String> inputtedCarNames) {
        this.carNames = inputtedCarNames;
    }

    public String getSingleCarName(int index) {
        return carNames.get(index);
    }

    public int getNumberOfCars() {
        return carNames.size();
    }
}
