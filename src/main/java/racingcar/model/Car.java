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
        validation.checkNullNameInInput(input);
        Map<String, Integer> carNameList = new LinkedHashMap<>();
        for (String carName : input.split(DELIMETER)) {
            validation.checkNameTokenLengthOver(carName);
            validation.checkNameTokenDuplicated(carName, carNameList);
            carNameList.put(carName, 0);
        }
        return carNameList;
    }
}
