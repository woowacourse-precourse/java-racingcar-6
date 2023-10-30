package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SettingGame {
    private final HashMap<String, Integer> cars = new LinkedHashMap<>();

    public HashMap<String, Integer> settingcar() {
        String input_carName = Console.readLine();
        String[] carNameList = input_carName.split(",");

        for (String carName : carNameList) {
            ValidCheck.duplicate_check(cars.keySet(), carName);
            ValidCheck.nameSize_check(carName);
            cars.put(carName, 0);
        }

        return cars;
    }

    public int numberOfGame() {
        String input = Console.readLine();
        return ValidCheck.moveTypeCheck(input);
    }
}