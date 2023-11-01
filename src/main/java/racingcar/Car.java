package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public boolean checkForward() {
        int randomNumber = makeRandomNumber();

        if (randomNumber < GameNumber.GO.getNumber()) {
            return false;
        }

        return true;
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
