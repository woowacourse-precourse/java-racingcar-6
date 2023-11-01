package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNum {
    public Integer Number() {
        int computerNum = Randoms.pickNumberInRange(0, 9);
        if (computerNum >= 4) {
            return 1;
        }else{
            return 2;
        }
    }
}
