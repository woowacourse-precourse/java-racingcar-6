package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    private RandomUtil() {}

    public static int generateRandomValue(int min, int max) {
        if(min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        if(min == max) return min;

        return Randoms.pickNumberInRange(min, max);
    }

}
