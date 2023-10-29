package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String username;
    private String currentLocation;

    public RacingCar(String username) {
        this.username = username;
        this.currentLocation = getStartLocation();
    }

    public String getStartLocation() {
        return "";
    }

    public String getUsername() {
        return username;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public int pickRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMoreThanFour(int pickNumber) {
        return pickNumber >= 4;
    }

    public void moveForwardOneSpace(String go) {
        this.currentLocation += go;
    }
}