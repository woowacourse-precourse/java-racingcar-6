package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final int STARTING_POINT_INT = 0;

    public static int findFarthestCarPosition(List<Car> carList) {
        int farthestCarPosition = STARTING_POINT_INT;

        for (Car car : carList) {
            farthestCarPosition = Math.max(farthestCarPosition, car.getPositionInt());
        }
        return farthestCarPosition;
    }

    public static List<String> winnerList(List<Car> carList, int farthestCarPosition) {
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPositionInt() == farthestCarPosition) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
