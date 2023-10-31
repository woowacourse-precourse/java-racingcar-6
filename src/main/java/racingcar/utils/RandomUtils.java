package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int generateRandomNumber(int minNum, int maxNum) {
        int randomNumber = Randoms.pickNumberInRange(minNum, maxNum);
        return randomNumber;
    }
}
