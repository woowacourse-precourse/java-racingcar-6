package racingcar;

import static racingcar.CommandLine.show;

public class Car {

    private String name;
    private int moveForwardCount;

    public String getName() {
        return name;
    }

    public int getMoveForwardCount() {
        return this.moveForwardCount;
    }

    public Car(String name, int moveForwardCount) {
        this.name = name;
        this.moveForwardCount = moveForwardCount;
    }

    public void moveForward() {
        this.moveForwardCount += 1;
    }

    public void showCurrentMoveForward() {
        String moveForwardMark = "";
        for (int j = 0; j < this.moveForwardCount; j++) {
            moveForwardMark += "-";
        }
        show(getName() + " : " + moveForwardMark);
    }
}
