package racingcar.Utils;

import camp.nextstep.edu.missionutils.Randoms

public class Random {
    public int generateRandomNum(){
        return Randoms.pickNumberInRange(0, 9);
    }
}