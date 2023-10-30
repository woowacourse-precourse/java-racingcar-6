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
}
