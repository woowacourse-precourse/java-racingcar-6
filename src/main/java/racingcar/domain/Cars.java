package racingcar.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public void init(String[] carArr) {
        for (String carName : carArr) {
            carList.add(new Car(carName, 0));
        }
    }

    public List<Car> getCarList() {
        return unmodifiableList(carList);
    }
}