package racingcar.view;

import java.util.List;

public class Finish {


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
