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

    public void showCurrentStep() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < currentStep; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public String getName() {
        return name;
    }
}