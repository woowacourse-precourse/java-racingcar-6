package racingcar.domain;

public class Car {

    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void move() {
        MovementDecider movementDecider = new MovementDecider();
        if (movementDecider.movable()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " +  "-".repeat(position);
    }
}
