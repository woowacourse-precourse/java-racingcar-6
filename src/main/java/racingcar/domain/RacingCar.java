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

    public String createRoundResult() {
        return carName + " : " + repeatDash();
    }

    private String repeatDash() {
        return "-".repeat(Math.max(0, position));
    }

}
