package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Move {
    public int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean judgeNum() {
        return true;
    }
}
