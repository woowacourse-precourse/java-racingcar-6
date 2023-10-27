package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

public class CompareRace {

    public RacingCar moveCars(RacingCar racingCar, Integer movement) {
        for (int i = 0; i < movement; i++) {
            Integer movementCondition = getRandomNumber();

            if (movementCondition >= 4) {
                racingCar.forward();
            }
        }

        return racingCar;
    }

    private Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
