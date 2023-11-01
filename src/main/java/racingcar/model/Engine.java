package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Engine {
    public int power;

    public Engine() {
        this.power = generatePower();
    }

    private int generatePower() {
        return Randoms.pickNumberInRange(0,9);
    }

    private void runEngine() {
        this.power = Randoms.pickNumberInRange(0,9);
    }

    public void setEngine(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
