package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validator;

public class Car {
    private final String name;
    private int currentPosition;
    private static final int CAN_MOVE_NUMBER = 4;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    private void validateName(String name) {
        Validator.validateName(name);
    }

    public void moveIfRandomSuccess() {
        if (createRandomNumber() >= CAN_MOVE_NUMBER) {
            currentPosition++;
        }
    }

    protected int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
