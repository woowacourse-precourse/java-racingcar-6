package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int createRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

}
