package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String carName;
    private int position = 0;

    public RacingCar(String carName) {
        this.carName = carName;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position += 1;
        }
    }

}
