package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {
    private final String DISTANCE_CHAR = "-";
    public void moveForward(String name, Map<String,String> users){
        String distance = users.get(name);
        distance += DISTANCE_CHAR;
        users.replace(name,distance);
    }
}
