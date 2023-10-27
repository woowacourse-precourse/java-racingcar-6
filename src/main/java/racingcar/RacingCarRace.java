package racingcar;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.*;
import static racingcar.constant.NumberConstant.ZERO_POINT;

public final class RacingCarRace {

    private final List<RacingCar> racingCars;
    private final int attemptCount;

    private RacingCarRace(final List<RacingCar> racingCars, final int attemptCount) {
        this.racingCars = racingCars;
        this.attemptCount = attemptCount;
    }

    public static RacingCarRace createRacingCarRace(final String[] carNames, final int attemptCount) {
        List<RacingCar> racingCars = Arrays
                .stream(carNames)
                .map(RacingCar::of)
                .collect(toList());

        return new RacingCarRace(racingCars, attemptCount);
    }

    public void runRace() {
        racingCars.forEach(RacingCar::move);
    }

    public List<RacingCar> findWinners() {
        int maxPoint = getMaxPoint();

        return racingCars.stream()
                .filter(racingCar -> maxPoint == racingCar.getWinningPoint())
                .collect(toList());
    }

    private int getMaxPoint() {
        int maxPoint = ZERO_POINT;

        for (RacingCar racingCar : racingCars) {
            if (maxPoint < racingCar.getWinningPoint()) {
                maxPoint = racingCar.getWinningPoint();
            }
        }
        return maxPoint;
    }

    // getter
    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
