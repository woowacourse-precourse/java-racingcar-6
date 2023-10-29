package service;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceWinnerDecider {
    public static ArrayList<String> decideWinner(HashMap<String, Integer> carList) {
        ArrayList<String> winners = new ArrayList<>();

        int maxDistance = 0;
        for (String carName : carList.keySet()) {
            int distance = carList.get(carName);
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(carName);
            } else if (distance == maxDistance) {
                winners.add(carName);
            }
        }

        return winners;
    }

}
