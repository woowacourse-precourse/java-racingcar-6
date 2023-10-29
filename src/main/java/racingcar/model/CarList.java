package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    List<Car> carList = new ArrayList<>();

    public CarList(String carNames) {
        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
    }
}
