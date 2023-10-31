package racingcar.domain;

public class Car {
    private static final int MIN_MOVE_CONDITION = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(int moveCondition) {
        if (moveCondition >= MIN_MOVE_CONDITION) {
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
