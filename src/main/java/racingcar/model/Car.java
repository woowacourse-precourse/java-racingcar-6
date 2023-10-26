package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isCarMoving() {
        int randomNumber = generateRandomNumber();
        return randomNumber > 3;
    }
}
