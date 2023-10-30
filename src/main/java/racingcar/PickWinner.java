package racingcar;

import java.util.ArrayList;
import java.util.List;

public class PickWinner {
    public static List<String> compareDistance(List<Car> carList) {
        List<String> winnerNameList = new ArrayList<>();
        String max = "";

        for (Car car : carList) {
            if (max.length() < car.getDistance().length()) {
                max = car.getDistance();
                winnerNameList.clear();
                winnerNameList.add(car.getName());
            } else if (max.length() == car.getDistance().length()) {
                winnerNameList.add(car.getName());
            }
        }
        return winnerNameList;
    }
}
