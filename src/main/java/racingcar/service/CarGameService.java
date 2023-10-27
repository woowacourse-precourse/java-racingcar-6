package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Cars;

public class CarGameService {

    private static final String NAME_SEPARATOR = ",";

    public Cars convertToList(String inputCars) {
        List<String> names = new ArrayList<>(getCarList(inputCars));
        return Cars.of(names);
    }

    public void repeatForward(Cars cars) {
        cars.evaluateCondition();
    }

    public String receiveWinnerNames(Cars cars) {
        return cars.receiveResult();
    }

    private List<String> getCarList(String inputCars) {
        return Arrays.asList(splitCars(inputCars));
    }

    private String[] splitCars(String inputCars) {
        return inputCars.split(NAME_SEPARATOR);
    }
}
