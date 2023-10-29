package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Forward {
    int forward = 0;
    public int randomNums() {
        int randomsNum = Randoms.pickNumberInRange(0, 9);
        return randomsNum;
    }

    public int canForward() {
        int randomsNum = randomNums();
        if(randomsNum >= 4) {
            forward++;
        }
        return forward;
    }


    public int result() {
        return 0;
    }


}
