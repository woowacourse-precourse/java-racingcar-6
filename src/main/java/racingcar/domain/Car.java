package racingcar.domain;

public class Car {
    private final String NAME;
    private int position = 0;

    public Car(String name) {
        this.NAME = name;
    }

    public void go() {
        position++;
    }

    public int getPosition() {
        return position;
    }

}
