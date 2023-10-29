package racingcar.model;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        this.position++;
    }

    public String positionDrawDash() {
        StringBuilder positionDash = new StringBuilder();
        for (int positionCnt = 0; positionCnt < this.position; positionCnt++) {
            positionDash.append("-");
        }
        return positionDash.toString();
    }

    public Map<String, String> getCarInfo() {
        Map<String, String> carInfoMap = new HashMap<>();
        String carPosition = positionDrawDash();

        carInfoMap.put("name", name);
        carInfoMap.put("position", carPosition);

        return carInfoMap;
    }
}
