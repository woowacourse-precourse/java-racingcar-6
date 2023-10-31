package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private final List<Car> carList = new ArrayList<>();


    public void addCar(Car car) {
        carList.add(car);
    }
}
