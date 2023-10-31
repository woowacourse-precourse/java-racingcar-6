package service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovementDecider {
    public static boolean moveDecide() {
        int randomPick =  Randoms.pickNumberInRange(0, 9);
        return randomPick >= 4;
    }

}
