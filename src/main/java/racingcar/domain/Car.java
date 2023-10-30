package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(Constants.MIN_INPUT_RANGE, Constants.MAX_INPUT_RANGE);
        if (randomNumber >= Constants.MIN_MOVE_THRESHOLD) {
            increasePosition();
        }
    }

    public void increasePosition() {
        this.position++;
    }
}
