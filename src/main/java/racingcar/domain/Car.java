package racingcar.domain;

import java.util.Arrays;

public class Car implements Comparable<Car> {
    private static final int FRONT_MOVE = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isEquals(String... carNames) {
        return Arrays.asList(carNames).contains(this.name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void move(int randomVal) {
        if (isMove(randomVal)) {
            position++;
        }
    }

    private boolean isMove(int randomVal) {
        return randomVal >= FRONT_MOVE;
    }

    public String makeRecord() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" : ");
        sb.append("-".repeat(Math.max(0, position)));

        return sb.toString();
    }

    @Override
    public int compareTo(Car car) {
        if(this.position > car.position)
            return 1;
        else if (this.position == car.position)
            return 0;

        return -1;
    }
}
