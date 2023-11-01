package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.BoundaryValues.*;

public class Random {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(minRandomNumber, maxRandomNumber);
    }

    public static boolean isGo() {
        return getRandomNumber() >= goCondition;
    }


}
