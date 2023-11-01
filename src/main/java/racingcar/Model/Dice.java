package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Dice {
    private Integer value;

    public Dice() {
        this.value = 0;
    }

    public Integer getValue() {
        return value;
    }

    public void rolling() {
        this.value = Randoms.pickNumberInRange(0,9);
    }
}
