package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void go() {
        location++;
    }

    @Override
    public int compareTo(Car car) {
        return Integer.compare(this.location, car.location);
    }
}
