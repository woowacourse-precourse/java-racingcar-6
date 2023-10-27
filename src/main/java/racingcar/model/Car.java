package racingcar.model;

import static racingcar.constant.AllConstants.DELIMETER;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.controller.Validation;

public class Car {
    private final Validation validation;
    public Car() {
        this.validation = new Validation();
    }

    public Map<String, Integer> createCarNameList(String input) {
        validation.nameLengthZero(input);
        Map<String, Integer> carNameList = new LinkedHashMap<>();
        for (String carName : input.split(DELIMETER)) {
            validation.overNameLengthLimit(carName);
            validation.nameDuplicated(carName, carNameList);
            carNameList.put(carName, 0);
        }
        return carNameList;
    }
}
