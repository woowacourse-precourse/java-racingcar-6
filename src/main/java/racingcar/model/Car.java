package racingcar.model;

import racingcar.controller.NumberGenerator;

public class Car {
    private final String name;
    private int forwardDistance;

    public Car(String name) {
        this.name = name;
        this.forwardDistance = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardDistance() {
        return this.forwardDistance;
    }

    public void moveOnRandomCondition() {
        if (NumberGenerator.generateRandom() >= 4) {
            forwardDistance++;
        }
    }

    public void displayProgress() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.forwardDistance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
