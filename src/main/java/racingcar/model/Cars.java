package racingcar.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Cars {
    private List<String> cars;

    private HashMap<String, String> carsStatus;

    public Cars(List<String> cars, HashMap<String, String> carsStatus) {
        this.cars = cars;
        this.carsStatus = carsStatus;
    }

    public void initCarsStatus() {
        LinkedHashMap<String, String> initCarsStatus = new LinkedHashMap<>();
        for (String car : cars) {
            initCarsStatus.put(car, "");
        }
        carsStatus = initCarsStatus;
    }

    public HashMap<String, String> getCarsStatus() {
        return carsStatus;
    }

}
