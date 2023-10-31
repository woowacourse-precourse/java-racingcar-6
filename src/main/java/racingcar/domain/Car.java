package racingcar.domain;

public class Car {
    private static final int START_POSITION = 0;
    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(CarState carState) {
        if (carState == CarState.MOVE) {
            position++;
        }
    }
}