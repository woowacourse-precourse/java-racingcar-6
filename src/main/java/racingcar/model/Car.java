package racingcar.model;

import java.util.LinkedHashMap;

public class Car {

    private String carName;

    private LinkedHashMap<String, Integer> cars;

    public Car(LinkedHashMap<String, Integer> cars) {
        this.cars = cars;
    }


    public int moveForward(int carNumber) {

        return 0;
    }

    public LinkedHashMap<String, Integer> createLocationMap(String[] carNames) {
        cars = new LinkedHashMap<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.putIfAbsent(carNames[i], 0);
        }
        return cars;
    }


}
