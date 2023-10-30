package racingcar.common.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static int makeRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
