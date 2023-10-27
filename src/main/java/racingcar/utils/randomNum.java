package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class randomNum {
    public int makeRandomNum(){
        Integer randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
}
