package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int setRandomNumber(int start, int end){
        int num = Randoms.pickNumberInRange(start, end);
        return num;
    }
}
