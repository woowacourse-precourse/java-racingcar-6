package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public Integer generate(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
}
