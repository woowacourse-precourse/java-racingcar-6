package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    // 내로남불
    public static int generateRandomNumber(int minNum, int maxNum) {
        int randomNumber = Randoms.pickNumberInRange(minNum, maxNum);
        return randomNumber;
    }
}
