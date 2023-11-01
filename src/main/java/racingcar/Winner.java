package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    List<String> winners;
    public List<String> findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int winnerDist = calculateMaxDist(cars);

        for (Car car : cars){
            if (car.nowPosition() == winnerDist){
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int calculateMaxDist(List<Car> cars){
        int max = 0;
        for (Car car : cars){
            if (car.nowPosition() > max){
                max = car.nowPosition();
            }
        }

        return max;
    }

}
