package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private int maxDistance = 0;

    public void carCompare(List<Integer> carDistance) {
        for (Integer distance : carDistance) {
            if (distanceCompare(distance)) {
                maxDistance = distance;
            }
        }
    }

    public List<String> findWinner(List<String> nameList, List<Integer> carDistance) {
        List<String> winnerList = new ArrayList<>();
        for (int order = 0; order < nameList.size(); order++) {
            if (maxDistance == carDistance.get(order)) {
                winnerList.add(nameList.get(order));
            }
        }
        return winnerList;
    }

    private boolean distanceCompare(int distance) {
        return maxDistance <= distance;
    }
}
