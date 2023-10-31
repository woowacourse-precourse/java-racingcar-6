package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public int createRandomNumber(){
        int random = Randoms.pickNumberInRange(0,9);
        return random;
    }
}
