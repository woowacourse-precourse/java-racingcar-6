package racingcar.v4;

import camp.nextstep.edu.missionutils.Randoms;

public class Forward {
    public int randomNums() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean canForward(int randomsNum) {
        return randomsNum >= 4;
    }

}
