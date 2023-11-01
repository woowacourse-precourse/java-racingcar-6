package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WinnerCalculator {

    public ArrayList<String> calculateWinner(HashMap<String, String> finalResult, ArrayList<String> carNames) {

        HashMap<String, Integer> pathLength = calculatePathLength(finalResult, carNames);
        ArrayList<String> winnerNames = new ArrayList<>();
        int maxLength = Collections.max(calculatePathLength(finalResult, carNames).values());

        for (int i = 0; i < pathLength.size(); i++) {
            if (pathLength.get(carNames.get(i)) == maxLength) {
                winnerNames.add(carNames.get(i));
            }
        }
        return winnerNames;
    }

    public HashMap<String, Integer> calculatePathLength(HashMap<String, String> finalResult, ArrayList<String> carNames) {
        HashMap<String, Integer> winnersPath = new HashMap<>();

        for (int i = 0; i < finalResult.size(); i++) {
            String eachCarName = carNames.get(i);
            winnersPath.put(eachCarName, finalResult.get(eachCarName).length());
        }
        return winnersPath;
    }
}
