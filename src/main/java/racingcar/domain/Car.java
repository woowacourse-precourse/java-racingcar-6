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

    public Boolean isWinner(Car car) {
        return position.equals(car.position);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public Name getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        return position.compareTo(o.position);
    }
}
