package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class JudgeStopAndGo {

    boolean judgeStopAndGo() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            return true;
        }
        return false;
    }
}
