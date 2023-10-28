package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarCreator {

    public List<String> splitPlayerInput(String playerInput) {
        return arrayToList(playerInput.split(","));
    }

    public void validateCarNameList(List<String> carNameList) {
        carNameList.forEach(this::validateCarName);
    }

    public List<Car> createCars(List<String> carNameList) {
        return null;
    }

    private List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty() || carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
