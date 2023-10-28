package racingcar.domain;

import java.util.LinkedHashMap;

public class Car {
    private LinkedHashMap<String, String> carList;

    public LinkedHashMap<String, String> getCarList() {
        return carList;
    }

    public void setCarList(LinkedHashMap<String, String> carList) {
        this.carList = carList;
    }

    public void getCurrentRacingResult() {
        getCarList().forEach((key, value) -> {
            System.out.println(key + " :" + " " + value);
        });
    }
}
