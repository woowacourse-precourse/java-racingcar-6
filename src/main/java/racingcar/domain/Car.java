package racingcar.domain;

public class Car {

    private final int MOVE_FORWARD_MIN = 4;

    private CarName name;
    private CarPosition position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void goForwardByNumber(int number) {
        if (number >= MOVE_FORWARD_MIN) {
            position.increase();
        }
    }

    @Override
    public String toString() {
        return name.toString() + " : " + position.toString();
    }

}