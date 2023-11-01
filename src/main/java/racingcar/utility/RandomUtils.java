package racingcar.utility;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int generateRandomValue(){
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }
}
