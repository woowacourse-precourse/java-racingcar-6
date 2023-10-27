package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Validator;

import java.util.Arrays;
import java.util.List;

public class InputController {

    public static List<String> setCars() {

        String cars = Console.readLine();
        List<String> carList = Arrays.asList(cars.split(","));
        Validator.validateCarNames(carList);

        return carList;

    }

    public static int setNumber() {

        int number = Integer.parseInt(Console.readLine());

        return number;

    }
}
