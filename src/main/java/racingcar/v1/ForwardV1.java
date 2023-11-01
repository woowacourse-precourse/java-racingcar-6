package racingcar.v1;

import camp.nextstep.edu.missionutils.Randoms;

public class ForwardV1 {
    static int forward = 0;

    public int randomNums() {
        int randomsNum = Randoms.pickNumberInRange(0, 9);
        return randomsNum;
    }

    public boolean canForward() {
        int randomsNum = randomNums();
        if (randomsNum >= 4) {
            forward++;
            return true;
        }
        return false;
    }

}
