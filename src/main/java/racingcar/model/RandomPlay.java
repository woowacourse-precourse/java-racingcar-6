package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPlay {
    public static int generateRandomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }

}
