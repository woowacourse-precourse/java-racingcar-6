package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class ForwardChecker {
    public final int FORWARD_STANDARD = 4;

    public boolean isForward(){
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= FORWARD_STANDARD;
    }
}
