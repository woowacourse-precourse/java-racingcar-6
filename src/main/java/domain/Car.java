package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void run() {
        if (getRandomNum() >= 4) {
            goOneStep();
        }
    }

    public String getName() {
        return name;
    }

    void goOneStep() {
        step += 1;
    }

    public int getStep() {
        return step;
    }
}
