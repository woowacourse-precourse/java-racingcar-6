package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;

public class DiceUtils {
    public static int getDiceRoLl(int min, int max) {
        return Randoms.pickNumberInRange(min,max);
    }
}
