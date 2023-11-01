package racingcar.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RaceOutput {
    public static void raceOutput(LinkedHashMap<String, String> cars) {
        for (String car : cars.keySet()) {
            System.out.println(car + " : " + cars.get(car));
        }
        System.out.println();
    }
}
