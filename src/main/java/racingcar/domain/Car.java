package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_STANDARD = 4;
    private String name;
    private int currentStep;

    public Car(final String name) {
        this.name = name;
        this.currentStep = 0;
    }

    public void move() {
        currentStep += 1;
    }

    public void tryMove() {
        int pickNumber = Randoms.pickNumberInRange(0, 9);
        if (pickNumber >= RANDOM_STANDARD) {
            this.move();
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentStep() {
        return currentStep;
    }
}
