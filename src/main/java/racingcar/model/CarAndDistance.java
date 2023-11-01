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

    public String[] carAndDistanceResult(int i) {
        String[] test = new String[i];
        for(int j = 0; j < i; j++) {
            test[j] = carsNames.get(j) + " : " + carAndDistance.get(carsNames.get(j));
        }
        return test;
    }

    public LinkedHashMap<String, String> getCarAndDistance() {
        return this.carAndDistance;
    }
}

