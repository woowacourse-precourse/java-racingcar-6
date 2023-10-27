package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>, Model {
    private final String name;
    private int moved;
    Car(String name) {
        this.name = name;
    }

    public void moveOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moved++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoved() {
        return moved;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%s : ", name));
        print.append("-".repeat(moved));

        return print.toString();
    }

    @Override
    public int compareTo(Car other) {
        return other.moved - this.moved;
    }
}
