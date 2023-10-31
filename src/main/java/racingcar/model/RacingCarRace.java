package racingcar.model;

import java.util.Collections;
import java.util.List;

public class RacingCarRace {
    List<RacingCar> racingCars;
    List<String> winnerCarNames;
    int totalMoveCount;

    public RacingCarRace(List<RacingCar> givenRacingCars, int givenTotalMoveCount) {
        this.racingCars = givenRacingCars;
        this.totalMoveCount = givenTotalMoveCount;
    }

    public void move() {
        for(RacingCar racingCar: racingCars) {
            racingCar.randomStepForward();
        }
    }

    public List<String> getWinnerCarNames() {
        List<Integer> distanceTravels = racingCars.stream()
                .map(RacingCar::getDistanceTraveled).toList();

        int max = Collections.max(distanceTravels);
        winnerCarNames = racingCars.stream()
                .filter((racingCar) -> racingCar.getDistanceTraveled() == max)
                .map(RacingCar::getCarName).toList();

        return winnerCarNames;
    }


    public int getTotalMoveCount() {
        return totalMoveCount;
    }

    public List<String> getCarsStatus() {
        return racingCars.stream().map(RacingCar::getScore).toList();
    }
}
