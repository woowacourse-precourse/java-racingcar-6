package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CalculateCarsPositions {
    public static void initializationCarsPositions(List<String> cars) {
        List<Integer> carsPositions = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            carsPositions.add(0);
        }
    }

    public static void calculateCarsProgresses(List<Integer> carsPositions) {
        for (int i = 0; i < carsPositions.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            if (randomNumber >= 4) {
                carsPositions.set(i, carsPositions.get(i) + 1);
            }
        }
    }
}
