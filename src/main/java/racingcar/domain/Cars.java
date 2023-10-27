package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> cars;

    public Cars(List<String> carNameList) {
        cars = new ArrayList<>();
        addCarInCars(carNameList);
    }

    private void addCarInCars(List<String> carNameList) {
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }
    }
}
