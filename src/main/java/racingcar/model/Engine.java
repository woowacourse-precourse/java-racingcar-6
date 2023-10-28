package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    public final int power;

    public Engine() {
        this.power = generatePower();
    }

    private int generatePower() {
        return Randoms.pickNumberInRange(0,9);
    }

    public int getPower() {
        return power;
    }
}
