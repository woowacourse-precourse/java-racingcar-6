package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int INIT_VAL = 0;
    private static final String PROCESS_INDICATOR = "-";

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INIT_VAL;
    }

    public String getName() {
        return name;
    }

    public String process() {
        return (PROCESS_INDICATOR.repeat(position));
    }

    public void updatePosition() {
        position++;
    }

    public boolean isSamePosition(Car car) {
        return car.position == this.position;
    }

    public boolean isNameLongerThenCriteria(int criteria) {
        return name.length() > criteria;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
