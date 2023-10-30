package racingcar.domain;

public class Car {
    private static final int MIN_MOVE_COND = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveCond) {
        if (moveCond>= MIN_MOVE_COND) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
