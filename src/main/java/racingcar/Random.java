package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import static racingcar.Stationary.*;

public class Random {
    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(minRandomNumber, maxRandomNumber);
    }

    public static boolean isGo(int randomNumber) {
        return getRandomNumber() >= goCondition;
    }


}
