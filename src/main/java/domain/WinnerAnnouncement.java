package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinnerAnnouncement {
    private HashMap<String, Integer> carLocationMap;
    private List<String> winners = new ArrayList<>();

    public HashMap<String, Integer> setCarData(HashMap<String, Integer> carData) {
        carLocationMap = carData;
        return carLocationMap;
    }

    public void winnerDecision() {
        int highest = -1;
        for (String car : carLocationMap.keySet()) {
            int location = carLocationMap.get(car);
            if (location > highest) {
                winners.clear();
                highest = location;
                winners.add(car);
            } else if (location == highest) {
                winners.add(car);
            }
        }
    }

    public List<String> getWinner() {
        return winners;
    }
}
