package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Referee {

    public Map<String, Boolean> checkTryOutcome(List<String> names, List<Integer> randomNumbers) {
        final int MIN_MOVABLE_NUMBER = 4;
        Map<String, Boolean> tryResult = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            if (randomNumbers.get(i) >= MIN_MOVABLE_NUMBER) {
                tryResult.put(names.get(i), true);
                continue;
            }
            tryResult.put(names.get(i), false);
        }

        return tryResult;
    }

    public List<String> checkWinner(Map<String, Integer> moveResult) {
        List<String> winner = new ArrayList<>();
        int maxScore = 0;
        for (Map.Entry<String, Integer> resultOfCar : moveResult.entrySet()) {
            if (maxScore == resultOfCar.getValue()) {
                winner.add(resultOfCar.getKey());
                continue;
            }
            if (maxScore < resultOfCar.getValue()) {
                maxScore = resultOfCar.getValue();
                winner.clear();
                winner.add(resultOfCar.getKey());
            }
        }

        return winner;
    }
}
