package tdd.service;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import tdd.domain.Car;

public class RaceResultGenerator {
    public static LinkedHashMap<String, Integer> generate(LinkedHashSet<Car> cars) {
        LinkedHashMap<String, Integer> raceResult = new LinkedHashMap<>();
        for (Car car : cars) {
            raceResult.put(car.getName(), car.getMoved());
        }
        return raceResult;
    }
}