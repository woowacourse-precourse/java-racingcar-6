package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputController {

    public static List<String> setCars() {
        String cars = Console.readLine();

        return Arrays.asList(cars.split(","));
    }

    public static int setNumber() {
        int number = Integer.parseInt(Console.readLine());

        return number;
    }
}
