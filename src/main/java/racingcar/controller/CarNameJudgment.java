package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.CarObject;

public class CarNameJudgment {
    private List<String> cars = new ArrayList<>();

    public List<String> split(String carName) {
        this.cars = Arrays.asList(carName.split(","));

        for (var car : this.cars) {
            carNameSizeJudgment(car);
        }

        return cars;
    }

    public void carNameSizeJudgment(String carName) {
        if(carName.length() <= CarObject.CAR_NAME_LIMIT_SIZE) {
            cars.add(carName);
        }
    }
}
