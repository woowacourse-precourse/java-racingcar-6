package racingcar.domain;

import java.util.Map;

public class Car {
    public void move(Map<String, Integer> carList, String name) {
        carList.replace(name, carList.get(name) + 1);
    }
}
