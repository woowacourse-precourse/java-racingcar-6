package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RaceGameStateModel {
    private int totalRound;
    private LinkedHashMap<String, Integer> userCarDistance;

    public RaceGameStateModel(int totalRound, List<String> userCars) {
        this.totalRound = totalRound;
        initializeUserCarDistance(userCars);
    }

    public void initializeUserCarDistance(List<String> userCars) {
        this.userCarDistance = new LinkedHashMap<>();
        for (String userCar : userCars) {
            userCarDistance.put(userCar, 0);
        }
    }

    public int getTotalRound() {
        return totalRound;
    }

    public void setTotalRound(int totalRound) {
        this.totalRound = totalRound;
    }

    public LinkedHashMap<String, Integer> getUserCarDistance() {
        return userCarDistance;
    }

    public Integer getUserCarDistance(String key) {
        return userCarDistance.get(key);
    }

    public void updateUserDistance(String key, int newValue) {
        this.userCarDistance.put(key, newValue);
    }
}
