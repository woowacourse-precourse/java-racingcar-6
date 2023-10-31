package racingcar.controller;

import java.util.List;
import java.util.Arrays;

public class RacerManager {
    public List<String> seperateCarName(String input) {
        String[] cars = input.split(",");
        return Arrays.asList(cars);
    }
}
