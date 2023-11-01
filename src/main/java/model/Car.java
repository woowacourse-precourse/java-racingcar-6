package model;

import camp.nextstep.edu.missionutils.Randoms;
import config.GameProperty;
import java.util.HashMap;
import java.util.Map;

public class Car {

    private final static int MIN_RANDOM_RANGE = GameProperty.getMinMoveForRange();
    private final static int MAX_RANDOM_RANGE = GameProperty.getMaxRandomRange();
    private final static int FOR_MOVE_NUMBER = GameProperty.getForMoveNumber();
    String name;
    int location = 0;

    private Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE) > FOR_MOVE_NUMBER) {
            this.location++;
        }
    }

    public Map<String, Object> getCarLocation() {
        Map<String, Object> carInfo = new HashMap<>();
        carInfo.put("name", this.name);
        carInfo.put("location", this.location);
        return carInfo;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
