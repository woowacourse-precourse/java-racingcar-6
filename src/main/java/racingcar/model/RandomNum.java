package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    public static int randomNumberGenerator(){
        return Randoms.pickNumberInRange(0,9);
    }
}
