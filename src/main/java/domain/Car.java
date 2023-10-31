package domain;

public class Car implements Comparable<Car> {
    private static final int STOP = 3;
    private final String name;
    private int distance;

    public Car(final String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(final String name) {
        this.name = name;
    }


    public void move(final int value) {
        if(value > STOP) {
            distance++;
        }
    }

    public int getDistance() { return distance; }
    public String getName() { return name; }

    @Override
    public int compareTo(Car o) {
        return o.distance - this.distance;
    }
}
