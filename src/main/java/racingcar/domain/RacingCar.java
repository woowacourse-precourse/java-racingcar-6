package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String name;
    private int randomNumber;

    public RacingCar(String name) {
        this.name = name;
    }

    private void makeRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }
}
