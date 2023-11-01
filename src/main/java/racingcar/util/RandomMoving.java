package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoving {
    public boolean isMovable() {
        int randomNumber = getRandomNumber();

        return randomNumber >= 4;
    }

    private static int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
