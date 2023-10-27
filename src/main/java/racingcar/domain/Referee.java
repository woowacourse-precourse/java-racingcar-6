package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Referee {

    public static List<String> determineWinner(List<Car> cars){
        List<String> winners = new ArrayList<>();
        int maxDistance = findMaxDistance(cars);
        for(Car car : cars){
            if(car.getTotalMovedDistance() == maxDistance)
                winners.add(car.getName());
        }
        return winners;
    }
    private static int findMaxDistance(List<Car> cars){
        int maxDistance = 0;
        for(Car car : cars){
            if(maxDistance< car.getTotalMovedDistance())
                maxDistance = car.getTotalMovedDistance();
        }
        return maxDistance;
    }
}
