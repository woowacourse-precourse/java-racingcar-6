package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class Cars {
    private List<String> cars;

    public Cars(List<String> cars) {
        this.cars = cars;
    }

    public HashMap<String, String> initCarsMap() {
        HashMap<String, String> carsMap = new HashMap<>();
        for (String car : cars) {
            carsMap.put(car, "");
        }
        return carsMap;
    }


}
