package racingcar.service;

import java.util.List;
import racingcar.domain.RacingCar;

public class Referee {

    public static int getMaxDistance(List<RacingCar> racingCars) {
        int maxDistance = 0;
        for (RacingCar racingCar : racingCars) {
            maxDistance = Math.max(maxDistance, racingCar.getDistance());
        }
        return maxDistance;
    }

}