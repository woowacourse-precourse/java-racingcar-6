package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    Map<String, Car> cars = new HashMap<>();

    public Map<String, Car> makeCarList(String inputName) {
        String[] carNames = inputName.split(",");

        for (String carName : carNames) {
            addList(carName);
        }

        return cars;
    }

    public void addList(String name) {
        cars.put(name, new Car(name, 0));
    }

    public List<String> findChampionGroup(Map<String, Car> result) {
        List<String> championNames = new ArrayList<>();
        int maxDistance = findMaxDistance(result);

        for (Car car : result.values()) {
            if (car.getDistance() == maxDistance) {
                championNames.add(car.getName());
            }
        }

        return championNames;
    }

    public int findMaxDistance(Map<String, Car> result) {
        int maxDistance = Integer.MIN_VALUE;

        for (Car car : result.values()) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }

}
