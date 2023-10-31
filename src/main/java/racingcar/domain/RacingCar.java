package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;


import static racingcar.constant.NumberConstant.*;
import static racingcar.constant.TextConstant.*;

public final class RacingCar {

    private final String carName;

    private String currentLocation;
    private int winningPoint;

    private RacingCar(final String carName, final String currentLocation, final int winningPoint) {
        this.carName = carName;
        this.currentLocation = currentLocation;
        this.winningPoint = winningPoint;
    }

    public static RacingCar of(final String carName) {
        return new RacingCar(carName, BLANK, ZERO_POINT);
    }

    public void move(final int randomNumber) {
        if (randomNumber > MIN_MOVEMENT_CONDITION_NUMBER) {
            currentLocation += HYPHEN;
            winningPoint += ONE_POINT;
        }
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    // getter
    public String getCarName() {
        return carName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public int getWinningPoint() {
        return winningPoint;
    }
}
