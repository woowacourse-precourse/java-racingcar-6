package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    public static int getRandomNumber(int randomStartNumber, int randomLastNumber) {
        if (randomStartNumber == randomLastNumber) {
            return randomStartNumber;
        }
        return Randoms.pickNumberInRange(randomStartNumber, randomLastNumber);
    }
}
