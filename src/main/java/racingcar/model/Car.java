package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void calculatePosition(boolean moveState) {
        if (moveState) {
            this.position++;
        }
    }

    public Map<String, Object> provideCarStatus() {
        Map<String, Object> carStatus = new HashMap<>();
        carStatus.put("name", name);
        carStatus.put("position", position);
        return carStatus;
    }
}
