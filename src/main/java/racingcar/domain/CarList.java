package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarList {
    private static final String SPLIT_CONDITION = ",";

    private final List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public String[] splitCarNames(String carNames) {
        return splitName(carNames);
    }

    private String[] splitName(String carNames) {
        return carNames.split(SPLIT_CONDITION);
    }

    public void addCars(String[] carNameArray) {
        Arrays.stream(carNameArray)
                .map(Car::new)
                .forEach(carList::add);
    }

    public Winners getWinners() {
        return new Winners(carList);
    }
}