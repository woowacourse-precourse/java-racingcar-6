package racingcar.model;

import racingcar.validation.InputValidation;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private Map<String, Integer> movingCars;

    public Map<String, Integer> getMovingCars() {
        return movingCars;
    }

    public void inputCars(String carNames){
        movingCars = InputValidation.checkedInputValidation(carNames);
    }
}
