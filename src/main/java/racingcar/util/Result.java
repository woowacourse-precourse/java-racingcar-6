package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class Result {
    public static int checkMaxDistance(List<Car> parkingLot){
        int maxDistance = -1;
        for(int i=0;i<parkingLot.size();i++)
            maxDistance = Math.max(parkingLot.get(i).getForwardDistance(), maxDistance);
        return maxDistance;
    }
}
