package racingcar.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class CarAndDistance {
    private LinkedHashMap<String, String> carAndDistance;
    private List<String> carsNames;

    public CarAndDistance() {
        carAndDistance = new LinkedHashMap<>();
        carsNames = new ArrayList<>();
    }

    public void setCarAndDistance(String carName, String distance) {
        carAndDistance.put(carName, distance);
        carsNames.add(carName);
    }

    public String carAndDistanceResult(int i) {
        return carsNames.get(i) + " : " + carAndDistance.get(carsNames.get(i));
    }

    public LinkedHashMap<String, String> getCarAndDistance() {
        return this.carAndDistance;
    }
}

