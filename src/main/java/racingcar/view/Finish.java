package racingcar.view;

import java.util.List;

public class Finish {
    public static void victoryCars(int currentLocation[], List<String> carsName) {
        int victoryScore = victoryDistance(currentLocation, carsName);
        int carMaxIndex = carsName.size();
        List<String> victoryResult = null;
        for (int carNumber = 0; carNumber < carMaxIndex; carNumber++) {
            if (victoryScore == currentLocation[carNumber]) {
                victoryResult.add(carsName.get(carNumber));
            }
        }
        String finalResult = String.join(",", victoryResult);
        System.out.println("최종 우승자 " + finalResult);
    }

    private static int victoryDistance(int currentLocation[], List<String> carsName) {
        int maxDistance = 0;
        int carMaxIndex = carsName.size();
        for (int carNumber = 0; carNumber < carMaxIndex; carNumber++) {
            if (maxDistance < currentLocation[carNumber])
                maxDistance = currentLocation[carNumber];
        }
        return maxDistance;
    }

}
