package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void addPosition() {
        this.position += 1;
    }
}
