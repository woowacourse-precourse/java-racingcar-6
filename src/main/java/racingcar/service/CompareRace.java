package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class CompareRace {
    private static final Integer START_NUMBER = 0;
    private static final Integer END_NUMBER = 9;

    public void moveCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);;

            if (randomNumber >= 4) {
                racingCar.forward();
            }
        }
    }

    public List<RacingCar> findWinnerCars(List<RacingCar> doneRacingCars) {
        List<RacingCar> winnerCars = new ArrayList<>();

        for (RacingCar racingCar : doneRacingCars) {
            compareCarMovement(winnerCars, racingCar);
        }

        return winnerCars;
    }

    private void compareCarMovement(List<RacingCar> winnerCars, RacingCar racingCar) {
        if (winnerCars.isEmpty() || racingCar.hasHigherMovement(winnerCars.get(0))) {
            winnerCars.clear();
            winnerCars.add(racingCar);
        } else if (racingCar.hasEqualMovement(winnerCars.get(0))) {
            winnerCars.add(racingCar);
        }
    }
}
