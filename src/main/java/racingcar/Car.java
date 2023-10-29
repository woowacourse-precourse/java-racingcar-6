package racingcar;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public String process() {
        return ("-".repeat(position));
    }

    public void updatePosition() {
        position++;
    }

    public boolean isNameLongerThenCriteria(int criteria) {
        return name.length() > criteria;
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.position;
    }
}
