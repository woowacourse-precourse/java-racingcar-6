package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {
    public int generateNum(){
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return randomNum;
    }
}
