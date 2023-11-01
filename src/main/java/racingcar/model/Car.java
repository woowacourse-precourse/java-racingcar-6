package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Validator;

public class Car {
    private final String name;
    private int currentPosition;
    private static final int CAN_MOVE_NUMBER = 4;

    public Car(String name) {
        this.name = name;
        validateName(name);
        this.currentPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    private void validateName(String name) {
        Validator.validateNotNull(name);
        Validator.validateNotBlank(name);
        Validator.validateMaxLength(name);
        Validator.validateNoSpacesBetweenNames(name);
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
