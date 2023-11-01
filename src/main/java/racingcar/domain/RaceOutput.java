package racingcar.domain;

import java.util.HashMap;

public class RaceOutput {
    public static void raceOutput(HashMap<String, String> cars) {
        for (String car : cars.keySet()) {
            System.out.println(car + " : " + cars.get(car));
        }
        System.out.println();
    }
}
