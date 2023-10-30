package racingcar.controller;

import racingcar.Constants;
import racingcar.Util;
import racingcar.model.Validator;

import java.util.List;

public class CarController {
    public static List<String> setCars() {
        String input = readCarNamesFromUser();
        List<String> carList = Util.parseCarNames(input);
        Validator.validateCarNames(carList);
        return carList;
    }

    private static String readCarNamesFromUser() {
        try {
            return Util.readLine();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Constants.INVALID_NAME_INPUT_ERROR);
        }
    }
}
