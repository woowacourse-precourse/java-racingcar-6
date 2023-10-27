package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int INIT_POSITION = 0;
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    private int position;

    public Car(final String name) {
        validateSize(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    public Car(String name, int position) {
        validateSize(name);
        this.name = name;
        this.position = position;
    }

    private void validateSize(String name) {
        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("이름 크기는 5이하여야 합니다.");
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public void move() {
        this.position += 1;
    }
}
