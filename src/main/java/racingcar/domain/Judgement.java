package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Judgement {
    public List<String> judgeWinner(List<Car> carList) {
        int maxPoint;
        List<String> winners = new ArrayList<>();

        maxPoint = findMaxPoint(carList);
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getProgress() == maxPoint) {
                winners.add(carList.get(i).getName());
            }
        }
        return winners;
    }

    private int findMaxPoint(List<Car> carList) {
        int maxPoint = 0;
        for (int i = 0; i < carList.size(); i++) {
            maxPoint = Math.max(maxPoint, carList.get(i).getProgress());
        }
        return maxPoint;
    }
}
