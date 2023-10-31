package racingcar.domain;

import java.util.Arrays;

public class Car {
    private static final int FRONT_MOVE = 4;

    private String name;
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
        return Arrays.stream(carNames).anyMatch((carName) -> this.name.equals(carName));
    }

    @Override
    public String toString() {
        return "[" + this.name + ", " + this.position + "]";
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
}
