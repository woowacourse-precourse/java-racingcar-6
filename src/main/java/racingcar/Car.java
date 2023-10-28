package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (isMovable(randomValue)) {
            position++;
        }
    }

    public String getPositionString() {
        return "-".repeat(position);
    }

    public void printPosition() {
        System.out.println(name + " : " + getPositionString());
    }

    private boolean isMovable(int randomValue) {
        return randomValue >= 4;
    }
}
