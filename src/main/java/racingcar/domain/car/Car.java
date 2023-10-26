package racingcar.domain.car;

public class Car implements Comparable<Car> {

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
