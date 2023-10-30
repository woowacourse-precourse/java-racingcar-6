package racingcar.domain.car;

public class Car implements Comparable<Car> {

    public static final int CAR_MIN_POSITION = 0;
    private Name name;
    private int position;

    private Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position++;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }


    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public static Car createCar(Name name) {
        return new Car(name, CAR_MIN_POSITION);
    }
}
