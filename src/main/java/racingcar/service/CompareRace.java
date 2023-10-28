package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.List;

public class CompareRace {

    private final Integer START_NUMBER = 0;
    private final Integer END_NUMBER = 9;

    public void moveCars(List<RacingCar> racingCars, Integer movement) {
        for (int i = 0; i < movement; i++) {
            Integer movementCondition = getRandomNumber();

            if (movementCondition >= 4) {
                for (RacingCar racingCar : racingCars) {
                    racingCar.forward();
                }
            }
        }
    }

    private Integer getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public List<RacingCar> findWinnerCars(List<RacingCar> doneRacingCars) {
        for
    }
}
