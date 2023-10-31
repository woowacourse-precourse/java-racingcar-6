package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int currentStep = 0;

    public Car(String name) {
        this.name = name;
    }

    public boolean isMovingForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    public void startGameTurn() {
        if (isMovingForward()) {
            increaseCurrentStep();
        }
    }

    public void increaseCurrentStep() {
        this.currentStep++;
    }
}