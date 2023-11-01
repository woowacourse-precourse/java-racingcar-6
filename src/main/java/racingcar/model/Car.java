package racingcar.model;

public class Car implements Comparable<Car> {
    public String name;
    public int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void moveForward() {
        this.location++;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(o.location, this.location);
    }
}
