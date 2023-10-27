package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private static final int THRESHOLD = 4;
    private static final String DASH = "-";

    private String carName;
    private int distance;

    public RacingCar(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public void moveForward() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= THRESHOLD) {
            this.distance++;
        }
    }

    public String convertDistanceToString() {
        return DASH.repeat(distance);
    }

    public int getDistance() {
        return distance;
    }

    public String getCarName() {
        return carName;
    }

}