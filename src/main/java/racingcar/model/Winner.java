package racingcar.model;

import static racingcar.model.CarForward.forwardCountInt;
import static racingcar.view.InputView.cars;

import java.util.List;
import java.util.ArrayList;

public class Winner {
    public static List<String> maxCountCars = new ArrayList<>();

    public static void compareWinner() {
        int maxCount = 0;

        for (int i = 0; i < forwardCountInt.length; i++) {
            if (forwardCountInt[i] > maxCount) {
                maxCount = forwardCountInt[i];
                maxCountCars.clear();
                maxCountCars.add(cars[i]);
            }
            else if (forwardCountInt[i] == maxCount) {
                maxCountCars.add(cars[i]);
            }
        }
    }
}
