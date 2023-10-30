package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public void splitCarNames(String carNames) {
        String[] carNameArray = splitName(carNames);
        addCars(carNameArray);
    }

    public String[] splitName(String carNames) {
        return carNames.split(",");
    }

    public void addCars(String[] carNameArray) {
        Arrays.stream(carNameArray)
                .map(Car::new)
                .forEach(carList::add);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Winners getWinners() {
        return new Winners(carList);
    }

}