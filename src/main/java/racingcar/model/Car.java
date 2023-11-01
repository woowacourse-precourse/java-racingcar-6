package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void moveForward() {
        if (isMoving()) {
            this.location++;
        }
    }

    private boolean isMoving() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void printLocation() {
        String locationBar = "-".repeat(getLocation());
        System.out.println(getName() + " : " + locationBar);
    }
}
