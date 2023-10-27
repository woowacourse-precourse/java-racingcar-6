package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int moved;
    private Car(String name) {
        this.name = name;
    }
    public static Car generateCar(String name) {
        return new Car(name);
    }

    public void move(Integer count) {
        while (count > 0) {
            int value = Randoms.pickNumberInRange(0, 9);
            if (value >= 4) {
                moved++;
            }
            count--;
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
        return this.moved - other.moved;
    }
}
