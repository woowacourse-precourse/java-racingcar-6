package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private final HashMap<String, Integer> racingLineup;

    Car(String[] names) {
        this.racingLineup = new HashMap<>();
        for (String name : names) {
            this.racingLineup.put(name, 0);
        }
    }

}
