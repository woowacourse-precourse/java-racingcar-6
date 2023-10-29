package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.util.constant.ProductConstant.*;

public class RacingCar {
    private final String username;
    private String currentLocation;

    public RacingCar(String username) {
        this.username = username;
        this.currentLocation = getStartLocation();
    }

    public String getStartLocation() {
        return FIRST_LOCATION;
    }

    public String getUsername() {
        return username;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, LAST_NUMBER);
    }

    public boolean isMoreThanFour(int pickNumber) {
        return pickNumber >= MINIMUM_VALUE;
    }

    public void moveForwardOneSpace() {
        this.currentLocation += MOVE_ONE_SPACE;
    }
}