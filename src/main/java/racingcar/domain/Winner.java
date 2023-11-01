package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final int START_POINT_INT = 0;

    public static int findFarthestCarLocation(List<Car> carList) {
        int farthestCarLocation = START_POINT_INT;

        for (Car car : carList) {
            farthestCarLocation = Math.max(farthestCarLocation, car.getLocationInt());
        }
        return farthestCarLocation;
    }

    public static List<String> winnerList(List<Car> carList, int farthestCarLocation) {
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.getLocationInt() == farthestCarLocation) {
                winner.add(car.getName());
            }
        }
        return winner;
    }

}
