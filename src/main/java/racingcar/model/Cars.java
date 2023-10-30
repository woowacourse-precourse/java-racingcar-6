package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Cars {
    Map<String, Car> cars = new HashMap<>();

    public Map<String, Car> makeCarList(String inputName) {
        String[] carNames = inputName.split(",");

        for (String carName : carNames) {
            addList(carName);
        }

        return cars;
    }
    public void addList(String name) {
        cars.put(name, new Car(name, 0));
    }

}
