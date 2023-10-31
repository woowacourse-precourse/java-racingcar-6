package racingcar;

public class Car {

    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
