package racingcar.domain;

import static racingcar.utils.Calculation.createRandomNum;

public class Car {
    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public void run() {
        if (createRandomNum() >= 4) {
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
