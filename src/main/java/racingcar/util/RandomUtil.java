package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    Randoms randoms;

    public RandomUtil(Randoms randoms){
        this.randoms = randoms;
    }

    public static int generateRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
