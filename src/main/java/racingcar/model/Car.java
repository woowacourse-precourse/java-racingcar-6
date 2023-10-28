package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import static constant.MessgeList.MOVING_FORWARD;

public class Car {
    public Car() {
    }

    public int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    public boolean isCarMoveForward() {
        int randomNumber = generateRandomNumber();
        if (randomNumber >= MOVING_FORWARD) {
            return true;
        }
        return false;
    }
}
