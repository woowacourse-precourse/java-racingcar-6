package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static String detarminPostionByRandomNumber() {
        int randomNumber = makeRandomNumber();
        String position;
        if(randomNumber >= 4) {
            position = "STRAIGHT";
        }else {
            position = "STOP";
        }
        return position;
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

}
