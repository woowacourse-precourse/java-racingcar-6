package service;

import camp.nextstep.edu.missionutils.Randoms;
import repository.CarListRepository;

public class RandomMovementDecider {
    public static boolean moveDecide(String carName) {
        int randomPick =  Randoms.pickNumberInRange(0, 9);
        if(randomPick >= 4) {
            return true;
        }
        return false;
    }

}
