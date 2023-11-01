package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.TotalCar;

public class Winner {
    private int maxDistance = 0;

    public List<String> who(TotalCar totalCar) {
        carCompare(totalCar.distanceList());
        return findWinner(totalCar.nameList(), totalCar.distanceList());
    }

    public void carCompare(List<Integer> carDistance) {
        for (Integer distance : carDistance) {
            if (distanceCompare(distance)) {
                maxDistance = distance;
            }
        }
    }

    public boolean distanceCompare(int distance) {
        return maxDistance <= distance;
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
}
