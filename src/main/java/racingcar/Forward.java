package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Forward {
    public int randomNums() {
        int randomsNum = Randoms.pickNumberInRange(0, 9);
        return randomsNum;
    }

    public boolean canForward() {
        int randomsNum = randomNums();
        return randomsNum >= 4;
    }

}
