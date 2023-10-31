package racingcar.domain;


public class Car implements Comparable<Car> {
    private static final int MOVING_FORWARD = 4;

    private final Name name;
    private final Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(int number) {
        if (number >= MOVING_FORWARD) {
            position.increase();
        }
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }
}
