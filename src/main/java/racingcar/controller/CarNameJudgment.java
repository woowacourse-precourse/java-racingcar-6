package racingcar.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import racingcar.model.CarObject;

public class CarNameJudgment {
    private HashMap<String, Integer> cars;
    private List<String> carsName;

    private CarNameJudgment(String carName) {
        this.carsName = Arrays.asList(carName.split(","));

        for (var car : this.carsName) {
            carNameSizeJudgment(car);
        }
    }

    private void carNameSizeJudgment(String carName) {
        if (carName.length() <= CarObject.CAR_NAME_LIMIT_SIZE) {
            cars.put(carName, 0);
        }
    }

    private HashMap<String, Integer> getCars() {
        return cars;
    }

    public static HashMap<String, Integer> splitOf(String carName) {
        return new CarNameJudgment(carName).getCars();
    }
}
