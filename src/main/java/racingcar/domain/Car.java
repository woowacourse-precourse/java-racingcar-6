package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MOVE_CONDITION = 4;
    private final Name name;
    private int position = 0;

    private Car(Name name) {
        this.name = name;
    }

    public boolean isEqualPosition(Car car) {
        if (this.position == car.position) {
            return true;
        }
        return false;
    }
    public void changePosition(int number) {
        if (number >= MOVE_CONDITION) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name.getValue();
    }

    public static Car from(Object name) {
        return new Car(Name.from(name));
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
