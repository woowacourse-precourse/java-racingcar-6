package racingcar.view;

import java.util.List;

public class ScorePrint {
    public static void resultByOrder(int currentLocation[], List<String> carsName) {
        int carMaxIndex = carsName.size();
        for (int carNumber = 0; carNumber < carMaxIndex; carNumber++) {
            carNamePrint(carsName.get(carNumber));
            carMoveDistance(currentLocation[carNumber]);
        }
        System.out.println();
    }

    private static void carNamePrint(String name) {
        System.out.print(name + " : ");
    }

    private static void carMoveDistance(int distance) {
        while (distance > 0) {
            System.out.print("-");
            distance--;
        }
        System.out.println();
    }
}
