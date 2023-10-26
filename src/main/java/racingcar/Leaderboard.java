package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Leaderboard {
    private static Map<Car, String> map;

    static void makeCarInstanceList() {
        map = new LinkedHashMap<>();
        for (String car : View.getCarList()) {
            Car carInstance = new Car(car);
            map.put(carInstance, carInstance.getDistanceTraveled());
        }
    }

    static void race() {
        for (Car car : map.keySet()) {
            if (car.isMovingForward()) {
                car.moveForward();
            }
            map.put(car, car.getDistanceTraveled());
        }
    }

    static void printRaceProgress() {
        for (Entry<Car, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getCarName() + " : " + entry.getValue());
        }
    }

    static String printResult() {
        int maxValue = Collections.max(map.values()).length();
        List<String> Winner = new ArrayList<>();
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for (Entry<Car, String> entry : map.entrySet()) {
            if (entry.getValue().length() == maxValue) {
                Winner.add(entry.getKey().getCarName());
            }
        }
        for (String s : Winner) {
            result.append(s);
        }
        return result.toString();
    }
}
