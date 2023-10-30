package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> carList;

    public CarList() {
        carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }
}
