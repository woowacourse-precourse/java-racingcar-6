package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class Finish {
    public static void victoryCars(int currentLocation[], List<String> carsName) {
        int victoryScore = victoryDistance(currentLocation);
        int carMaxIndex = carsName.size();
        List<String> victoryResult = new ArrayList<>();
        for (int carNumber = 0; carNumber < carMaxIndex; carNumber++) {
            if (victoryScore == currentLocation[carNumber]) {
                victoryResult.add(carsName.get(carNumber));
            }
        }
        String finalResult = String.join(",", victoryResult);
        System.out.println("최종 우승자 : " + finalResult);
    }

    private static int victoryDistance(int currentLocation[]) {
        int maxDistance = 0;
        int carMaxIndex = currentLocation.length;
        for (int carNumber = 0; carNumber < carMaxIndex; carNumber++) {
            if (maxDistance < currentLocation[carNumber])
                maxDistance = currentLocation[carNumber];
        }
        return maxDistance;
    }

}
