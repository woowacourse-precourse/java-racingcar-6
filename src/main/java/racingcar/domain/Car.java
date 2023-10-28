package racingcar.domain;

public class Car {

    public static final int MOVE_CONDITION = 4;

    private final String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

}
