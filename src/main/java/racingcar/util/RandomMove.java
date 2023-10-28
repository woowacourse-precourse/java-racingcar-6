package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMove {
    public boolean isMove(){
        return (Randoms.pickNumberInRange(0, 9) >= 4);
    }
}
