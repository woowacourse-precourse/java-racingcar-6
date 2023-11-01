package racingcar;

import static java.util.Collections.max;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Leaderboard {
    private static Map<Car, String> map;

    static void makeCarInstanceList() {
        map = new LinkedHashMap<>();
        for (String car : Player.getCarList()) {
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

    static void printResult() {
        int maxValue = max(map.values()).length();
        List<String> Winner = new ArrayList<>();
        for (Entry<Car, String> entry : map.entrySet()) {
            if (entry.getValue().length() == maxValue) {
                Winner.add(entry.getKey().getCarName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", Winner));
    }

    public static Map<Car, String> getMap() {
        return map;
    }
}