package racingcar.controller;

import racingcar.Util;
import racingcar.model.Validator;

import java.util.Arrays;
import java.util.List;

public class CarController {
    public static List<String> setCars() {

        try {
            String cars = Util.readLine();
            List<String> carList = Arrays.asList(cars.split(","));
            Validator.validateCarNames(carList);

            return carList;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
