package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private final String name;
    private int distance;

    public RacingCar(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void go() {
        int randomNum = Randoms.pickNumberInRange(0,9);
        if (randomNum < 4) {
            return;
        }
        this.distance = this.distance + 1;
    }
}
