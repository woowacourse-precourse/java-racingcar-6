package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    public static int generateRandomNumber(){
        return Randoms.pickNumberInRange(RANDOM_MIN,RANDOM_MAX);
    }
}
