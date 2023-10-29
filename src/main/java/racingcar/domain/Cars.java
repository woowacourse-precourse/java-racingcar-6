package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private Map<String, Car> cars = new HashMap<>();

    public Map<String, Car> getCars() {
        return cars;
    }

    public void makeCarsFromCarList(List<String> carNameList) {
        for (String carName : carNameList) {
            Car car = new Car(carName);
            cars.put(carName, car);
        }
    }
}

