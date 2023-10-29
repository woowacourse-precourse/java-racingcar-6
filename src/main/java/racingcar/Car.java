package racingcar;

import java.util.HashMap;
import java.util.Map;

public class Car {
    String name;
    int meter;

    Map<Integer, Integer> movingLog;

    public Car(String name) {
        this.name = name;
        this.meter = 0;
    }

    public void settingLog(int chance) {
        movingLog = new HashMap<>();
        for (int i = 1; i <= chance; i++) {
            movingLog.put(i, 0);
        }
    }

    public String printResult(int round) {
        return name + " : " + "-".repeat(movingLog.get(round));
    }
}
