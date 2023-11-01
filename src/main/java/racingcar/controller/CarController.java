package racingcar.controller;

import racingcar.Util;
import racingcar.model.Validator;

import java.util.List;

public class CarController {

    public static List<String> getCarNamesFromUser(String input) {
        List<String> carList = Util.parseCarNames(input);
        Validator.validateCarNames(carList);
        return carList;
    }

}
