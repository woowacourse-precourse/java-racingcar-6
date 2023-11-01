package racingcar.domain;

public class Car {
    private static final int INIT_POSITION = 0;
    private static final int MOVE_DISTANCE = 1;
    final String name;
    int position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void go() {
        position += MOVE_DISTANCE;
    }
}
