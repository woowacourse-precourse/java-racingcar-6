package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class GameUtils {


    public static String numToHyphen(int num) {
        return "-".repeat(num);
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
