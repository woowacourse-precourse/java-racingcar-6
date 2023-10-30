package racingcar.domain;

public class Car {

    private final int MOVING_FORWARD_CRITERION = 4;
    private String name;
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

    public void moveForward(int number) {
        if (number >= MOVING_FORWARD_CRITERION) {
            this.position++;
        }
    }
}
