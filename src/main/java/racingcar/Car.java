package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
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

    public Car(String name, int totalForward) {
        this.name = name;
        this.totalForward = totalForward;
    }

    public void tryMoving() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= 4) {
            totalForward++;
        }
    }

    protected String printMoving() {
        return "-".repeat(Math.max(0, totalForward));
    }

    @Override
    public String toString() {
        return name + " : " + printMoving();
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.totalForward, other.getTotalForward());
    }
}
