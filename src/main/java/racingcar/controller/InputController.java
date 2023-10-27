package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Validator;

import java.util.Arrays;
import java.util.List;

public class InputController {

    public static List<String> setCars() {

        try {
            String cars = Console.readLine();
            List<String> carList = Arrays.asList(cars.split(","));
            Validator.validateCarNames(carList);

            return carList;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int setNumber() {

        try {
            int number = Integer.parseInt(Console.readLine());

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
