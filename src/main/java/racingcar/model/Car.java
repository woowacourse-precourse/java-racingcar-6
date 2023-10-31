package racingcar.model;

import racingcar.util.RandomUtil;


import java.util.Collections;
import java.util.HashMap;

import java.util.Map;

public class Car {
    private static final int STANDARD_VALUE = 4;
    private static final int START_POSITION = 0;

    private static final HashMap<CarName, Integer> carMap = new HashMap<>();
    private final CarName carName;
    private int position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = START_POSITION;
    }

    public void go() {
        int random = RandomUtil.createRandomNumber();
        if (random >= STANDARD_VALUE) {
            position++;
            winner();
        }
    }

    private void winner() {
        carMap.put(getCarName(), position);
    }

    public static Map<CarName, Integer> getCarMap() {
        return Collections.unmodifiableMap(carMap);
    }

    public CarName getCarName() {
        return carName;
    }

    public String getPosition() {
        String bar = "";
        for (int i = 0; i < position; i++) {
            bar += "-";
        }
        return bar;
    }
}
