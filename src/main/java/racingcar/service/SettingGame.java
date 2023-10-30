package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SettingGame {
    private final HashMap<String, Integer> cars = new LinkedHashMap<>();

    public HashMap<String, Integer> settingcar() {
        String input_carName = Console.readLine();
        String[] car_name = input_carName.split(",");

        for (String s : car_name) {
            ValidCheck.nameSize_check(s);
            cars.put(s, 0);
        }

        return cars;
    }

    public int numberOfGame() {
        String input = Console.readLine();
        return ValidCheck.moveTypeCheck(input);
    }
}