package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerater {
    public int generateNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
}
