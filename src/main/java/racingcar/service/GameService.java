package racingcar.service;

import java.util.ArrayList;
import java.util.HashMap;

public class GameService {
    public ArrayList<String> checkWinners(HashMap<String, Integer> cars) {
        ArrayList<String> winners = new ArrayList<>();
        int winScore = 0;
        int currentScore = 0;
        for (String name : cars.keySet()) {
            currentScore = cars.get(name);
            if (currentScore > winScore) {
                winScore = currentScore;
            }
        }
        for (String name : cars.keySet()) {
            currentScore = cars.get(name);
            if (currentScore == winScore) {
                winners.add(name);
            }
        }
        return winners;
    }
}
