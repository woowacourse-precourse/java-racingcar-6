package racingcar;

import java.util.ArrayList;
import java.util.List;

public class WhoIsWinner {

    public static List<String> compareDistance(List<Car> carList) {

        List<String> winnerGroup = new ArrayList<>();
        String highestScore = "";
        for (Car car : carList) {
            if (car.getDistance().length() > highestScore.length()) {
                highestScore = car.getDistance();
                winnerGroup.clear();
                winnerGroup.add(car.getName());
            } else if (car.getDistance().length() == highestScore.length()) {
                winnerGroup.add(car.getName());
            }
        }
        return winnerGroup;
    }

}
