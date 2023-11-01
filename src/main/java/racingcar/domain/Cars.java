package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList = new ArrayList<>();

    public void add(Car car) {
        carList.add(car);
    }
}
