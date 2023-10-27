package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;

public class Car {

    private String carName;
    private LinkedHashMap<String, Integer> cars;

    public Car(LinkedHashMap<String, Integer> cars) {
        this.cars = cars;
    }


    public int moveForward(String carName,int carNumber) {

        return 0;
    }

    public LinkedHashMap<String, Integer> createLocationMap(List<String> carNameList) {
        cars = new LinkedHashMap<>();
        for (int i = 0; i < carNameList.size(); i++) {
            cars.putIfAbsent(carNameList.get(i), 0);
        }
        return cars;
    }


}
