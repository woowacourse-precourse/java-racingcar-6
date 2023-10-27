package racingcar.model;

import static racingcar.constant.AllConstants.DELIMETER;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
    private final String input;
    public Car(String input) {
        this.input = input;
    }

    public Map<String, Integer> createCarNameList(String input) {
        Map<String, Integer> carNameList = new LinkedHashMap<>();
        for (String carName : input.split(DELIMETER)) {
            //validateOverNameLengthLimit(carName);
            //validateNameDuplicated(carName, carNameList);
            carNameList.put(carName, 0);
        }
        return carNameList;
    }
}
