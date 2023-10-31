package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public void addCars(String[] carNameArray) {
        Arrays.stream(carNameArray)
                .map(Car::new)
                .forEach(carList::add);
    }
    public void moveAllCars() {
        for (Car car : carList) {
            car.stopOrMove();
        }
    }

    public Winners getWinners() {
        return new Winners(carList);
    }
}