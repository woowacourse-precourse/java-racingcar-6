package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtil {

    private static int MAX_NUM = 9;
    private static int MIN_NUM = 0;

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
