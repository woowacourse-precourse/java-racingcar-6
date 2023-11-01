package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int position;

    public Car(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward() {
        ++this.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }
}
