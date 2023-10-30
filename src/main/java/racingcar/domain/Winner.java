package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {

    static final String REST = ",";

    public static int carMaxPosition(List<RacingCar> carList) {

        int maxPosition = 0;

        for (int i = 0; i < carList.size(); i++) {
            RacingCar car = carList.get(i);
            int carPosition = car.getDistance(i);
            maxPosition = Math.max(maxPosition, carPosition);
        }

        return maxPosition;
    }
    public static StringBuilder winnerList(List<RacingCar> carList) {

        StringBuilder finalWinner = new StringBuilder();

        int maxPosition = carMaxPosition(carList);

        for (int i = 0; i < carList.size(); i++) {
            RacingCar car = carList.get(i);
            String carName = car.getCarName(i);
            int carPosition = car.getDistance(i);
            if (maxPosition == carPosition) {
                finalWinner.append(carName);
                finalWinner.append(REST);
            }
        }

        int lastString = finalWinner.length() - 1;

        finalWinner.deleteCharAt(lastString);

        return finalWinner;

    }
}
