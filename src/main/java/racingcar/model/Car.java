package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String forwardMovementState;
    private int randomNumber;

    public void pickRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }
}
