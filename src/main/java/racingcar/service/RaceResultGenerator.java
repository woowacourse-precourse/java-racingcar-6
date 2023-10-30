package racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;

public class RaceResultGenerator {
    private final List<String> winners = new ArrayList<>();

    public List<String> checkWinner(LinkedHashSet<Car> cars) {
        LinkedHashMap<String, Integer> raceStatus = generateRaceStatus(cars);
        int max = Collections.max(raceStatus.values());

        for(Map.Entry<String, Integer> entry : raceStatus.entrySet()) {
            if(entry.getValue() == max) {
                winners.add(entry.getKey());
            }
        }
        return winners;
    }

    private LinkedHashMap<String, Integer> generateRaceStatus(LinkedHashSet<Car> cars) {
        LinkedHashMap<String, Integer> raceResult = new LinkedHashMap<>();

        for (Car car : cars) {
            raceResult.put(car.getName(), car.getMoved());
        }
        return raceResult;
    }
}