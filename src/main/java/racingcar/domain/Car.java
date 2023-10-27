package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_MOVE_COND = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (getCondition() >= MIN_MOVE_COND) {
            position++;
        }
    }

    public int getPosition() {
        final int copyPosition = position;
        return copyPosition;
    }

    public String getName() {
        return name;
    }

    private int getCondition() {
        return Randoms.pickNumberInRange(0, 9);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
