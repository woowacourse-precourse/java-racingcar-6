package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    public int getRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }
}
