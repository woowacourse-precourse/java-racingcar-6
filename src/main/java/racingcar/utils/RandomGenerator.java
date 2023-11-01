package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int getRandomNumber(int minimumNumber, int maximumNumber) {
        return Randoms.pickNumberInRange(minimumNumber, maximumNumber);
    }
}
