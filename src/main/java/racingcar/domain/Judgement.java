package racingcar.domain;

import java.util.*;

public class Judgement {
    public String judgeWinner(ArrayList<Car> carList) {
        int maxPoint;
        List<String> winners = new ArrayList<>();
        String result;

        maxPoint = findMaxPoint(carList);
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getProgress() == maxPoint) {
                winners.add(carList.get(i).getName());
            }
        }
        result = String.join(", ", winners);

        return result;
    }

    private int findMaxPoint(ArrayList<Car> carList) {
        int maxPoint = 0;
        for (int i = 0; i < carList.size(); i++) {
            maxPoint = Math.max(maxPoint, carList.get(i).getProgress());
        }
        return maxPoint;
    }
}
