package racingcar.Util;

import racingcar.domain.CarList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private static List<String> winnerList;
    private static int racingMaxLocation;

    public static List<String> carList(List<CarList> car) {
        find(maxLocation(car), car);
        return winnerList;
    }

    private static void find(int maxLocation, List<CarList> carList) {
        winnerList = new ArrayList<>();
        for (CarList car : carList) {
            if (maxLocation == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
    }

    public static int getRacingMaxLocation() {
        return racingMaxLocation;
    }

    private static int maxLocation(List<CarList> carList) {
        List<Integer> carPosition = new ArrayList<>();
        for (CarList car : carList) {
            carPosition.add(car.getPosition());
        }
        racingMaxLocation = Collections.max(carPosition);
        return racingMaxLocation;
    }
}
