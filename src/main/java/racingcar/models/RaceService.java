package racingcar.models;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceService {
    public void progressRound(List<RacingCar> racingCars) {
        racingCars.forEach((RacingCar racingCar) -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            racingCar.forward(randomNumber);
        });
    }

    public List<RacingCar> getWinners(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();
        int maxDistance = Integer.MIN_VALUE;
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getDistance() > maxDistance) {
                maxDistance = racingCar.getDistance();
            }
        }
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getDistance() == maxDistance) {
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
