package racingcar.model;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
