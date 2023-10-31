package racingcar.domain;

import java.util.List;

import static java.util.stream.Collectors.*;
import static racingcar.constant.NumberConstant.ZERO_POINT;
import static racingcar.constant.TextConstant.COMMA_BLANK;

public final class RacingCarRace {

    private final List<RacingCar> racingCars;
    private final int attemptCount;

    private RacingCarRace(final List<RacingCar> racingCars, final int attemptCount) {
        this.racingCars = racingCars;
        this.attemptCount = attemptCount;
    }

    public static RacingCarRace createRacingCarRace(final List<String> carNames, final int attemptCount) {
        List<RacingCar> racingCars = carNames.stream()
                .map(RacingCar::of)
                .collect(toList());

        return new RacingCarRace(racingCars, attemptCount);
    }

    public static String concatCarNames(final List<RacingCar> racingCars) {
        List<String> carNames = racingCars.stream()
                .map(RacingCar::getCarName)
                .toList();

        return String.join(COMMA_BLANK, carNames);
    }

    public void runRace() {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = racingCar.pickRandomNumber();
            racingCar.move(randomNumber);
        }
    }

    public List<RacingCar> findWinners() {
        int maxPoint = calculateMaxPoint();

        return racingCars.stream()
                .filter(racingCar -> maxPoint == racingCar.getWinningPoint())
                .collect(toList());
    }

    private int calculateMaxPoint() {
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
