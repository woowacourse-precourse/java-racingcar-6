package racingcar.controller;

import racingcar.model.Model;

import java.util.Map;

import static racingcar.Constant.InputMenu.*;

public class InputController {
    private final Model inputModel;
    public InputController(Model model) {
        inputModel = model;
    }
    public Map<String, String> createCarList(String carsInput) {
        return inputModel.createCarList(carsInput);
    }

    public void checkInvalidCarName(Map<String, String> carList) {
        for (String car : carList.keySet()) {
            if (car.length() > CAR_NAME_MAXIMUM_LENGTH) throw new IllegalArgumentException(EXCEPTION_INVALID_CAR_NAME);
        }
    }

    public void checkInvalidCount(String countInput){
        int count;
        try {
            count = Integer.parseInt(countInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_INVALID_INTEGER);
        }
        if (count == 0) throw new IllegalArgumentException(EXCEPTION_INVALID_INTEGER_ZERO);
        inputModel.setCount(count);
    }

}
