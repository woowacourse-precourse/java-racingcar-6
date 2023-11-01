package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int step;

    Car(String name) {
        this.name = name;
        this.step = 0;
    }

    static int getRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    void run() {
        if (getRandomNum() >= 4) {
            goOneStep();
        }
    }

    String getName() {
        return name;
    }

    void goOneStep() {
        step += 1;
    }

    int getStep() {
        return step;
    }
}
