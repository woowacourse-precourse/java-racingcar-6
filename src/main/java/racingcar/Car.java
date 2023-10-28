package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String distance = "";

    private void moveOnRandomChance() {
        int randomNumber = generateRandomNumber();
        if (isForward(randomNumber)) {
            distance += "-";
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= 4;
    }
}
