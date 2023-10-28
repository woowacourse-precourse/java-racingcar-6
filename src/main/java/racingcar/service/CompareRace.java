package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.List;

public class CompareRace {

    public List<RacingCar> moveCars(List<RacingCar> racingCars, Integer movement) {
        for (int i = 0; i < movement; i++) {
            Integer movementCondition = getRandomNumber();

            if (movementCondition >= 4) {
                for (RacingCar racingCar : racingCars) {
                    racingCar.forward();
                }
            }
        }

        return racingCars;
    }

    private Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
