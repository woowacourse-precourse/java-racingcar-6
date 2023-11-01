package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetWinners {
    public static void getWinners(List<String> cars, List<Integer> carsPositions) {
        List<String> winners = new ArrayList<>();
        int maxCount = Collections.max(carsPositions);

        for (int i = 0; i < cars.size(); i++) {
            if (carsPositions.get(i) == maxCount) {
                winners.add(cars.get(i));
            }
        }
    }
}
