package racingcar.domain;

import java.util.List;

public class Referee {

    private int findMaxDistance(List<Car> cars){
        int maxDistance = 0;
        for(Car car : cars){
            if(maxDistance< car.getTotalMovedDistance())
                maxDistance = car.getTotalMovedDistance();
        }
        return maxDistance;
    }
}
