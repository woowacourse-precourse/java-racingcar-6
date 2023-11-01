package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class RacingCarManager {

    private int numberOfAttempt;
    private final RacingCarList racingCarList;

    public RacingCarManager(int numberOfAttempt, RacingCarList racingCarList) {
        this.numberOfAttempt = numberOfAttempt;
        this.racingCarList = racingCarList;
    }

    public List<String> getWinnersName() {
        int maxAdvanceCount = racingCarList.getMaxAdvanceCount();
        return racingCarList.racingCars().stream()
                .filter(racingCar -> Objects.equals(racingCar.getAdvanceCount(), maxAdvanceCount))
                .map(RacingCar::getName)
                .toList();
    }

    public void decreaseNumberOfAttempt() {
        numberOfAttempt--;
    }

    public boolean isNotGameEnd() {
        return numberOfAttempt != 0;
    }

    public RacingCarList getRacingCarList() {
        return racingCarList;
    }
}
