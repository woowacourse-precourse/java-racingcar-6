package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberPicker {
    public int pickRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

}
