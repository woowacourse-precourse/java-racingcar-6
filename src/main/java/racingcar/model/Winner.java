package racingcar.model;

import static racingcar.model.CarForward.forwardCountInt;
import static racingcar.view.InputView.cars;

import java.util.List;
import java.util.ArrayList;

public class Winner {
    static List<String> maxCountCars = new ArrayList<>();

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

    public static String finalWinner() {
        if (!maxCountCars.isEmpty()) {
            System.out.print("최종 우승자 : ");
            for (int i = 0; i < maxCountCars.size(); i++) {
                System.out.print(maxCountCars.get(i));
                if (i < maxCountCars.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
