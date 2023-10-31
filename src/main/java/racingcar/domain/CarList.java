package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private final List<Car> carList;

    public CarList(CarNameList carNameList) {
        carList = new ArrayList<>();
        for (String carName : carNameList.getCarNameList()) {
            carList.add(new Car(carName));
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

}
