package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private final String name;
    private int totalForward;

    public String getName() {
        return name;
    }

    public int getTotalForward() {
        return totalForward;
    }

    public Car(String name) {
        this.name = name;
        this.totalForward = 0;
    }

    public void tryMoving() {
        int number = Randoms.pickNumberInRange(0,9);
        if (number >= 4) {
            totalForward++;
        }
    }

    private String printMoving() {
        StringBuilder moving = new StringBuilder();
        for(int i = 0; i < totalForward; i++) {
            moving.append('-');
        }
        return moving.toString();
    }

    @Override
    public String toString() {
        return name + " : " + printMoving();
    }

    @Override
    public int compareTo(Car other) {
        if (this.totalForward > other.getTotalForward()) {
            return 1;
        } else if (this.totalForward < other.getTotalForward()) {
            return -1;
        } else {
            return 0;
        }
    }
}
