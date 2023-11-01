package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_FINISH = 9;

    public int createRandomNumber(){
        int random = Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_FINISH);
        return random;
    }
}
