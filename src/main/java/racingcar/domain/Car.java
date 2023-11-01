package racingcar.domain;

public class Car {

    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

}
