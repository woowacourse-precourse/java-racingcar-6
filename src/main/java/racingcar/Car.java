package racingcar;

import java.util.Objects;

public class Car {
    private final String name;
    private Integer position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public Integer getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        position++;
    }

    public boolean atPosition(Integer position) {
        return this.position.equals(position);
    }

    public void printPosition() {
        String markers = GameConfig.POSITION_MARKER.repeat(position);
        String output = name + " : " + markers;
        System.out.println(output);
    }
}