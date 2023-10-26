package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private String name;

    private Integer distance;

    public void updateDistance(int randomNumber) {
        if (randomNumber >= 4) {
            distance++;
        }
    }
}
