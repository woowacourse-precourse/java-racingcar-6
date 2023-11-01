package utils.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static int getRandomNumber(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

}
