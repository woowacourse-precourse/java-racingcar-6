package racingcar;

import java.util.List;

public class GameUtil {

    public String getWinner(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();

        for(Car car : cars) {
            if(stringBuilder.isEmpty()) {
                stringBuilder.append(winnerCheck(car));
            } else {
                stringBuilder.append(", ").append(winnerCheck(car));
            }
        }

        return stringBuilder.toString();
    }

    public String winnerCheck(Car car) {
        if(car.getProgress().length() >= 5) {
            return car.getRacingCar();
        }
        return "";
    }

}
