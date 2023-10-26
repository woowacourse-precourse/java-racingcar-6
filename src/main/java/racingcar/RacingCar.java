package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.TextConstant.*;

public final class RacingCar {

    private final String carName;

    private String currentLocation;
    private int winningPoint;

    public RacingCar(final String carName, final String currentLocation, final int winningPoint) {
        this.carName = carName;
        this.currentLocation = currentLocation;
        this.winningPoint = winningPoint;
    }

    public static RacingCar of(final String carName) {
        return new RacingCar(carName, BLANK, ZERO_POINT);
    }

    public static List<RacingCar> createRacingCars(final String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar racingCar = RacingCar.of(carName);
            racingCars.add(racingCar);
        }

        return racingCars;
    }

    public static List<RacingCar> findWinners(final List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();
        int maxPoint = getMaxPoint(racingCars);

        for (RacingCar racingCar : racingCars) {
            if (maxPoint == racingCar.winningPoint) {
                winners.add(racingCar);
            }
        }

        return winners;
    }

    private static int getMaxPoint(final List<RacingCar> racingCars) {
        int maxPoint = ZERO_POINT;

        for (RacingCar racingCar : racingCars) {
            if (maxPoint < racingCar.winningPoint) {
                maxPoint = racingCar.winningPoint;
            }
        }
        return maxPoint;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

        if (randomNumber > MIN_MOVEMENT_CONDITION_NUMBER) {
            currentLocation += HYPHEN;
            winningPoint += ONE_POINT;
        }
    }

    // getter
    public String getCarName() {
        return carName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }
}
