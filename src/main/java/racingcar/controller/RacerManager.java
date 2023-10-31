package racingcar.controller;

import java.util.List;
import java.util.Arrays;

public class RacerManager {

    public static List<String> seperateRacersName(String input) {
        String[] cars = input.split(",");
        return Arrays.asList(cars);
    }

    public List<String> createRacer(List<String> values) {
        return Arrays.asList();
    }
}
