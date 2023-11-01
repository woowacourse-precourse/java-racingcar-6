package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    public static List<Car> findWinner(List<Car> cars) {
        List<Car> winnerCar = new ArrayList<>();

        for (Car car : cars) {
            if(car.getDistance()==getWinnersLength(cars)){
                winnerCar.add(car);
            }
        }
        return winnerCar;
    }

    private static int getWinnersLength(List<Car> cars) {
        int maxLength = 0;

        for (Car car : cars) {
            int carDistance = car.getDistance();
            if (carDistance > maxLength) {
                maxLength = carDistance;
            }
        }
        return maxLength;
    }

}