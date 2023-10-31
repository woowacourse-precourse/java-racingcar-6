package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> carList;

    public CarList(List<String> carNames) {
        carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

}
