package racingcar.model;

import static racingcar.constant.AllPunctuationMarks.COMMA;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.controller.Validation;

public class Car {

    private static final int INITIAL_MOVE_COUNT = 0;
    private final Validation validation;

    public Car() {
        this.validation = new Validation();
    }

    public Map<String, Integer> createCarNameList(String input) {
        Map<String, Integer> carNameList = new LinkedHashMap<>();
        validation.checkNullOrSpaceInNameInput(input);
        for (String carName : input.split(COMMA)) {
            validation.checkNameTokenLengthOver(carName);
            validation.checkNameTokenDuplicated(carName, carNameList);
            carNameList.put(carName, INITIAL_MOVE_COUNT);
        }
        return carNameList;
    }
}
