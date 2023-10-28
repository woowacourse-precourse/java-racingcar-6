package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class CompareRace {

    public void moveCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = racingCar.getRandomNumber();

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
