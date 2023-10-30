package racingcar.race;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    public int Generation() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
