package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public int getRandomNumber(int start, int end){
        return Randoms.pickNumberInRange(start, end);
    }
}
