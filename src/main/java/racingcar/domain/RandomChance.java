package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomChance {
        
    public int forwardCar() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
